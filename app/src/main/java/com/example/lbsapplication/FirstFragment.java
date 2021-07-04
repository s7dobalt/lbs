package com.example.lbsapplication;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class FirstFragment extends Fragment {

    View view;
    private MapView map = null;
    private IMapController mapController;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        /*
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        map = new MapView(getActivity());
        ((ConstraintLayout) root.findViewById(R.id.map)).addView(map);
        return root;

         */


        // Inflater um aus XML Layout zu bauen, R.layout.fragment_first sagt wo XML liegt
        view = inflater.inflate(R.layout.fragment_first, container, false );
        Context ctx = getActivity().getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map = view.findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        mapController = map.getController();
        mapController.setZoom(13);

        GeoPoint startPoint = new GeoPoint(50.73743, 7.0982068);
        mapController.setCenter(startPoint);

        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startMarker);

        if (Build.VERSION.SDK_INT >= 16) {
            map.setHasTransientState(true);
        }

        return view;

    }

    /*
    public View onViewCreated(LayoutInflater inflater, ViewGroup container, View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_first, container, false );


        return view;
    }

     */



    public void onResume(){

        super.onResume();
        //Acivity Declaration Cycle OnResume
        //sharedpreference can be used to save the configuration, and the following statements can be used when the configuration changes
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        //Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));
        map.onResume(); //needed for compass, my location overlays, v6.0.0 and up

    }



    public void onPause(){

        super.onPause();
        //Acivity declaration cycle OnPause
        //sharedpreference can be used to save the configuration, and the following statements can be used when the configuration changes
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        //Configuration.getInstance().save(getContext(), prefs);
        map.onPause(); //needed for compass, my location overlays, v6.0.0 and up

    }

    public void onDestroy() {
        super.onDestroy();

    }

}