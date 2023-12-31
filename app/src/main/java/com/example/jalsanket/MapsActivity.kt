package com.example.jalsanket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.jalsanket.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val bottomSheetFragment = BottomSheet()
        binding.btnBottomSheet.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }
        binding.btnReport.setOnClickListener {
            val intent = Intent(this@MapsActivity, Submission::class.java)
            startActivity(intent)
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        mMap.addMarker(MarkerOptions().position(mait).title("Marker in MAIT"))
        for (data in BottomSheet.hardcodedData) {
            val latLng = LatLng(data.latitude, data.longitude)
            val markerTitle = data.title
            val markerDescription = data.description

            // Create a marker with title and description
            val marker = MarkerOptions()
                .position(latLng)
                .title(markerTitle)
                .snippet(markerDescription)

            // Add the marker to the map
            googleMap.addMarker(marker)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        }

    }
}