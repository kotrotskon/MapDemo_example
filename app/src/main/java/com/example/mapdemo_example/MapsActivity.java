package com.example.mapdemo_example;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng datalabs = new LatLng(40.62822637820486, 22.950847850491648);

        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(datalabs)
                .title("Marker in Datalabs")
                .snippet("This is the datalbs")
        );



        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.628, 22.950))
                .title("This is the other Marker")
                .snippet("This is a marker")
        );

        mMap.addCircle(new CircleOptions()
                .center(datalabs)
                .radius(500)
                .strokeColor(Color.GREEN)
                .fillColor(0x550000FF)
                .clickable(true)
        );

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(40.6281, 22.9501))
                .add(new LatLng(40.629, 22.951))
                .add(new LatLng(40.627, 22.952))
                .color(Color.BLACK)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(datalabs, 14));
        mMap.setOnMarkerClickListener(this);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Log.d("ONMAP", "click on "+latLng.longitude+" "+latLng.latitude);
            }
        });
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d("MARKER", "click");
        return false;
    }
}