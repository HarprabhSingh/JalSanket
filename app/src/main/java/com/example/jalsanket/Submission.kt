package com.example.jalsanket


import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.view.View
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.jalsanket.data.ProblemData
import com.example.jalsanket.databinding.ActivitySubmissionBinding
import java.io.File
import java.io.InputStream

class Submission : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySubmissionBinding
    private var inputTitle: String = ""
    private var inputDesc: String = ""

    private lateinit var title: EditText
    private lateinit var desc: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubmissionBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        title=viewBinding.title
        desc=viewBinding.desc

        val viewModel = ViewModelProvider(this)[ViewModel::class.java]

        if (savedInstanceState != null) {
            inputTitle= savedInstanceState.getString("title", "")
            inputDesc   = savedInstanceState.getString("desc", "")
        }
        title.setText(inputTitle)
        desc.setText(inputDesc)

        // Retrieve the intent that started this activity
        val intent = intent
        val imageUri = intent.getParcelableExtra<Uri>("imageUri")

        // Retrieve the latitude and longitude values from the intent extras
        val title = viewBinding.title.text.toString()
        val desc = viewBinding.desc.text.toString()
        val latitude = intent.getDoubleExtra("lat", 0.0) // Default value 0.0 if not found
        val longitude = intent.getDoubleExtra("long", 0.0)
        val imageFile = imageUri?.let { createImageFileFromUri(this, it) }

        val problemData =ProblemData(title,desc,latitude,longitude)
        // Default value 0.0 if not found

        if (imageUri!=null){
            val contentResolver: ContentResolver = applicationContext.contentResolver
            try {
                val inputStream = contentResolver.openInputStream(imageUri)
                if (inputStream != null) {
                    // Decode the input stream into a Bitmap
                    val bitmap = BitmapFactory.decodeStream(inputStream)

                    // Set the Bitmap as the image for the ImageView
                    viewBinding.imageView.setImageBitmap(bitmap)

                    // Close the input stream
                    inputStream.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            viewBinding.imageView.visibility= View.VISIBLE

            viewBinding.button.text="Submit"
//               val newIcon = ResourcesCompat.getDrawable(resources,R.drawable.cloud_photo,null)
//               viewBinding.button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.cloud_photo,0,0,0)
        }

        if(viewBinding.button.text=="Submit"){
            viewBinding.button.setOnClickListener {
                if (imageFile != null) {
                    viewModel.sendMultipartData(problemData,imageFile)
                    Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"nah fam",Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            viewBinding.button.setOnClickListener {
                val intent = Intent(this, CameraActivity::class.java)
                startActivity(intent)

            }
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("title", title.text.toString())
        outState.putString("desc", desc.text.toString())

    }
    fun createImageFileFromUri(context: Context, imageUri: Uri): File? {
        // Check if the URI scheme is content
        if (imageUri.scheme == "content") {
            // Use content resolver to open an input stream
            val inputStream: InputStream? = context.contentResolver.openInputStream(imageUri)
            if (inputStream != null) {
                // Create a temporary file in your app's cache directory
                val cacheDir = context.cacheDir
                val tempFile = File.createTempFile("temp_image", ".jpg", cacheDir)

                // Copy the content from the input stream to the file
                tempFile.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }

                // Close the input stream
                inputStream.close()

                // Return the created file
                return tempFile
            }
        }else{
            Toast.makeText(this,"no",Toast.LENGTH_SHORT).show()
        }

        return null
    }
}