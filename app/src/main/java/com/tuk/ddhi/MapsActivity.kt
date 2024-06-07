package com.tuk.ddhi

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.tuk.ddhi.databinding.ActivityMapsBinding
import java.io.IOException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val REQUEST_LOCATION_PERMISSION = 45

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.isMyLocationEnabled = true
            getLastKnownLocation()
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION)
            }
        }

        mMap.setInfoWindowAdapter(CustomInfoWindowAdapter())

//        val address = "경기 시흥시 중심상가로 184"
//        val latLng = getLocationFromAddress(address)
//        val markerOptions = MarkerOptions().position(latLng).title("제주 은희네 해장국")
//        mMap.addMarker(markerOptions)
        addNewMarker("경기 시흥시 중심상가로 184", "제주 은희네 해장국")
        addNewMarker("경기 시흥시 중심상가 1길 18", "초지일관")
    }

    private fun getLastKnownLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    location?.let {
                        val currentLocation = LatLng(it.latitude, it.longitude)
                        Log.d("onMap", "Current location: ${it.latitude}, ${it.longitude}")
                        mMap.addMarker(MarkerOptions().position(currentLocation).title("현재 위치"))
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
                    } ?: run {
                        Log.e("onMap", "Location is null")
                    }
                }
                .addOnFailureListener {
                    Log.e("onMap", "Failed to get location", it)
                }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mMap.isMyLocationEnabled = true
                    getLastKnownLocation()
                }
            } else {
                Log.e("onMap", "Location permission denied")
            }
        }
    }

    private fun getLocationFromAddress(strAddress: String): LatLng {
        val geocoder = Geocoder(this)
        return try {
            val addressList = geocoder.getFromLocationName(strAddress, 1)
            if (addressList != null && addressList.isNotEmpty()) {
                val address = addressList[0]
                LatLng(address.latitude, address.longitude)
            } else {
                Log.e("getLocationFromAddress", "Address not found")
                LatLng(0.0, 0.0)
            }
        } catch (e: IOException) {
            e.printStackTrace()
            LatLng(0.0, 0.0)
        }
    }

    inner class CustomInfoWindowAdapter : GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowClickListener {

        private val window: View = LayoutInflater.from(this@MapsActivity).inflate(R.layout.info_window, null)

        init {
            mMap.setOnInfoWindowClickListener(this)
        }
        override fun getInfoWindow(marker: Marker): View? {
            render(marker, window)
            return window
        }

        override fun getInfoContents(marker: Marker): View? {
            render(marker, window)
            return window
        }

        private fun render(marker: Marker, view: View) {
            val title = marker.title
            val snippet = marker.snippet

            val titleTextView = view.findViewById<TextView>(R.id.b_nm)
            val snippetTextView = view.findViewById<TextView>(R.id.snippet)
            val kind = view.findViewById<TextView>(R.id.kind)
            val tag1 = view.findViewById<TextView>(R.id.tag1)
            val tag2 = view.findViewById<TextView>(R.id.tag2)
            val tag3 = view.findViewById<TextView>(R.id.tag3)

            titleTextView.text = title
            snippetTextView.text = snippet
            kind.text = "한식"
            tag1.text = "#태그1"
            tag2.text = "#태그2"
            tag3.text = "#태그3"
        }

        override fun onInfoWindowClick(p0: Marker) {
            val intent = Intent(this@MapsActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun addNewMarker(strAddress: String, b_nm: String){
        val address = strAddress
        val latLng = getLocationFromAddress(address)
        val markerOptions = MarkerOptions().position(latLng).title(b_nm)
        mMap.addMarker(markerOptions)
    }
}