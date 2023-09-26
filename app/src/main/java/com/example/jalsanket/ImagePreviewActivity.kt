package com.example.jalsanket

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.jalsanket.databinding.ActivityImagePreviewBinding

class ImagePreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImagePreviewBinding

//    private var title = intent.getStringExtra("title")
//    private var desc = intent.getBooleanArrayExtra("desc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityImagePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = intent.getParcelableExtra<Uri>("imageUri")
        // Load and display the captured image
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageURI(imageUri)

        binding.confirmButton.setOnClickListener {

            val location = getLastKnownLocation()

            var latitude : Double?=null
            var longitude : Double?=null

            if (location != null) {
                latitude = location.latitude
                longitude = location.longitude

                // Now you can save the image file along with location data in your app's storage
                // For example, you can store the image file path, latitude, and longitude in a database
                // or associate them in any other way suitable for your app.
            }

            val intent = Intent(this@ImagePreviewActivity, Submission::class.java)
            intent.putExtra("imageUri", imageUri)
                .putExtra("lat",latitude)
                .putExtra("long",longitude)
            startActivity(intent)
        }
        binding.rejectButton.setOnClickListener{
            val intent = Intent(this@ImagePreviewActivity, CameraActivity::class.java)
            startActivity(intent)
        }

    }
    @SuppressLint("MissingPermission")
    private fun getLastKnownLocation(): Location? {
        val locationManager = getSystemService(LOCATION_SERVICE) as android.location.LocationManager
        val providers = locationManager.getProviders(true)
        var bestLocation: Location? = null
        for (provider in providers) {
            val location = locationManager.getLastKnownLocation(provider)
            if (location != null && (bestLocation == null || location.accuracy < bestLocation.accuracy)) {
                bestLocation = location
            }
        }
        return bestLocation
    }
}