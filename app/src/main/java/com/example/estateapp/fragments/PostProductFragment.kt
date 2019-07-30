package com.example.estateapp.fragments


import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.estateapp.R
import kotlinx.android.synthetic.main.fragment_post_product.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import android.content.ContentResolver as ContentContentResolver


class PostProductFragment: Fragment(){


    var cal = Calendar.getInstance()


    private var btnSelectImage: LinearLayout? = null
    private var imageView: ImageView? = null
    private var GALLERY: Int = 1
    private var CAMERA: Int = 2


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_post_product,container,false)


        val dropDownTypeEstate = view.findViewById<Button>(R.id.dpdTypeEstate)
        dropDownTypeEstate.setOnClickListener {

            val popupMenu: PopupMenu = PopupMenu(activity,dropDownTypeEstate)

            popupMenu.menuInflater.inflate(R.menu.pop_up_menu_type_estate,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->

                when(item.itemId) {

                    R.id.item_house ->{

                        // field input House
                        inputHouseSize.visibility = View.VISIBLE
                        inputLandSize.visibility = View.VISIBLE
                        inputBathroomNumber.visibility = View.VISIBLE
                        inputBedroomNumber.visibility = View.VISIBLE


                        // field input Building
                        inputNameBuilding.visibility = View.GONE
                        inputBuildingSize.visibility = View.GONE


                        // field input Condo
                        inputNameCondo.visibility = View.GONE
                        inputSizeCondo.visibility = View.GONE


                        // field input Villa
                        inputVillaSize.visibility = View.GONE
                        inputTypeVilla.visibility = View.GONE
                    }

                    R.id.item_land ->{


                        inputHouseSize.visibility = View.GONE
                        inputBathroomNumber.visibility = View.GONE
                        inputBedroomNumber.visibility = View.GONE
                        inputLandSize.visibility = View.VISIBLE


                        // field input Building
                        inputNameBuilding.visibility = View.GONE
                        inputBuildingSize.visibility = View.GONE


                        // field input Condo
                        inputNameCondo.visibility = View.GONE
                        inputSizeCondo.visibility = View.GONE


                        // field input Villa
                        inputVillaSize.visibility = View.GONE
                        inputTypeVilla.visibility = View.GONE

                    }

                    R.id.item_condo ->{

                        // field input Condo
                        inputNameCondo.visibility = View.VISIBLE
                        inputSizeCondo.visibility = View.VISIBLE
                        inputBathroomNumber.visibility = View.VISIBLE
                        inputBedroomNumber.visibility = View.VISIBLE

                        // field input Land
                        inputLandSize.visibility = View.GONE


                        // field input Building
                        inputNameBuilding.visibility = View.GONE
                        inputBuildingSize.visibility = View.GONE
                    }

                    R.id.item_villa ->{

                        // field input Villa
                        inputVillaSize.visibility = View.VISIBLE
                        inputTypeVilla.visibility = View.VISIBLE
                        inputBathroomNumber.visibility = View.VISIBLE
                        inputBedroomNumber.visibility = View.VISIBLE


                        // field input Land
                        inputLandSize.visibility = View.GONE


                        // field input Building
                        inputNameBuilding.visibility = View.GONE
                        inputBuildingSize.visibility = View.GONE

                        // field input Condo
                        inputNameCondo.visibility = View.GONE
                        inputSizeCondo.visibility = View.GONE
                    }

                    R.id.item_building ->{

                        // field input Building
                        inputNameBuilding.visibility = View.VISIBLE
                        inputBuildingSize.visibility = View.VISIBLE
                        inputBathroomNumber.visibility = View.VISIBLE
                        inputBedroomNumber.visibility = View.VISIBLE


                        // field input Land
                        inputLandSize.visibility = View.GONE

                        // field input Condo
                        inputNameCondo.visibility = View.GONE


                        // field input Villa
                        inputVillaSize.visibility = View.GONE
                        inputTypeVilla.visibility = View.GONE
                    }

                }
                true
            })

            popupMenu.show()

        }


        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }


        val btnPost = view.findViewById<Button>(R.id.btn_postSale)

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        btnPost.setOnClickListener {

            DatePickerDialog(container!!.context,
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }




        btnSelectImage = view.findViewById(R.id.linear_image) as LinearLayout
        imageView = view.findViewById(R.id.imgPost) as ImageView


        btnSelectImage!!.setOnClickListener { showPictureDialog() }


        return view

    }


    // when you click on icon date picker, show DatePickerDialog that is set with OnDateSetListener
    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        tvDate!!.text = sdf.format(cal.time)
    }


    // dialog option to select image
    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(requireActivity())
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf("Select photo from gallery", "Capture photo from camera")
        pictureDialog.setItems(pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }


    // selection image from gallary
    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(galleryIntent, GALLERY)
    }

    // using camara to get image
    private fun takePhotoFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }


    public override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        /* if (resultCode == this.RESULT_CANCELED)
         {
         return
         }*/
        if (requestCode == GALLERY)
        {
            if (data != null)
            {
                val contentURI = data!!.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, contentURI)
//                    val path = saveImage(bitmap)
                    Toast.makeText(activity, "Image Saved!", Toast.LENGTH_SHORT).show()
                    imageView!!.setImageBitmap(bitmap)

                }
                catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(activity, "Failed!", Toast.LENGTH_SHORT).show()
                }

            }

        }
        else if (requestCode == CAMERA)
        {
            val thumbnail = data!!.extras!!.get("data") as Bitmap
            imageView!!.setImageBitmap(thumbnail)
//            saveImage(thumbnail)
            Toast.makeText(activity, "Image Saved!", Toast.LENGTH_SHORT).show()
        }
    }
}