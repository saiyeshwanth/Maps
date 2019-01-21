package com.example.android.maps

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Xml to kotlin
        var sFrag: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.fragment) as SupportMapFragment
        // googlemap object from Support map fragment
        sFrag.getMapAsync(object : OnMapReadyCallback {
            override fun onMapReady(gMap: GoogleMap?) {
                gMap?.mapType = GoogleMap.MAP_TYPE_NORMAL

                var lManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager //builtin location services
                lManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000L, 3F, object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        val lati = location?.latitude
                        val longi = location?.longitude
                    }

                    override fun onProviderDisabled(provider: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProviderEnabled(provider: String?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                }
                )
            }
        })

    }


}



