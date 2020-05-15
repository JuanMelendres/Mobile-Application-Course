package com.itesm.maps;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private LocationRequest solicitud;
    private Location lastLocation;
    private LocationCallback callback;

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
        LatLng salon = new LatLng(20.737030, -103.454188);
        mMap.addMarker(new MarkerOptions().position(salon).title("NUESTRO QUERIDO SALON"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(salon, 18));
        mMap.setOnMapClickListener(this);
        habilitarMyLocation();
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("marcador dinamico")
                .alpha(0.5f)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
    }

    public void habilitarMyLocation() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){

            String[] permisos = {Manifest.permission.ACCESS_FINE_LOCATION};
            requestPermissions(permisos, 0);
        } else {

            mMap.setMyLocationEnabled(true);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] p, int[] r){
        if(requestCode == 0 && r[0] == PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this, "SI ME DIERON PERMISO :D", Toast.LENGTH_SHORT).show();
            mMap.setMyLocationEnabled(true);
        } else {

            Toast.makeText(this, "NO ME DIERON PERMISO :'(", Toast.LENGTH_SHORT).show();
        }
    }
}
