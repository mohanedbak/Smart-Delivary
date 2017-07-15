package dp.smartdelivery;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class sendMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_map);
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

        LatLng loc1 = new LatLng(23.8150888,90.4255405);
        LatLng loc2 = new LatLng(23.8220818,90.42746369999998);
        LatLng loc3 = new LatLng(23.8135673,90.4221515);
        LatLng loc4 = new LatLng(23.7511536,90.3884376);
        LatLng loc5 = new LatLng(23.7419031,90.3808706);
        mMap.addMarker(new MarkerOptions().position(loc1).title("Book").snippet("TO :Dhanmondi"));
        mMap.addMarker(new MarkerOptions().position(loc2).title("Laptop").snippet("TO :Uttara"));
        mMap.addMarker(new MarkerOptions().position(loc3).title("Cloth").snippet("TO :Bongshal"));
        mMap.addMarker(new MarkerOptions().position(loc4).title("Food").snippet("TO :Uttara"));
        mMap.addMarker(new MarkerOptions().position(loc4).title("Medicine").snippet("TO :Sadarghat"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc1,14));
    }
}
