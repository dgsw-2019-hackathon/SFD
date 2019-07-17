package com.example.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jsoup.Jsoup;

import java.io.IOException;


public class dis_rescue  extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dis_rescue);
        new DownloadFilesTask().execute();
    }

    dis_rescue(){}

    Object object;

    dis_rescue(Object object){

        this.object = object;

    }

    @Override
    public void onMapReady(final GoogleMap map) {

        JsonObject obj = null;
        MarkerOptions markerOptions = new MarkerOptions();
        for(int i = 0; i < ((JsonArray) object).size(); i++) {
            obj = (JsonObject) ((JsonArray) object).get(i);
            LatLng SEOUL = new LatLng(obj.get("longitude").getAsDouble(), obj.get("latitude").getAsDouble() );
            markerOptions.position(SEOUL);
            markerOptions.title(obj.get("name").getAsString());
            markerOptions.snippet(obj.get("content").getAsString());
            map.addMarker(markerOptions);
            map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));

        }

        map.animateCamera(CameraUpdateFactory.zoomTo(1));
    }


    public void dis_rescue_bt(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.textView4:
                intent = new Intent(this, dis_rescue.class);
                startActivity(intent);
                break;
            case R.id.textView3:
                intent = new Intent(this, dis_info.class);
                startActivity(intent);
                break;
            case R.id.textView6:
                intent = new Intent(this, dis_way.class);
                startActivity(intent);
                break;
            case R.id.textView2:
                intent = new Intent(this, dis_main.class);
                startActivity(intent);
                break;
            case R.id.textView5:
                intent = new Intent(this, dis_sig.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAffinity(this);
        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    class DownloadFilesTask extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] objects) {
            JsonArray jsonArray = null;
            try {
                String jsonStr = Jsoup.connect(DATA.IP+"/run/")
                        .timeout(4000)
                        .userAgent("Mozilla")
                        .ignoreContentType(true)
                        .execute().body();
                JsonParser Parser = new JsonParser();
                jsonArray = (JsonArray) Parser.parse(""+jsonStr+"");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonArray;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            ((MapFragment)getFragmentManager()
                    .findFragmentById(R.id.map)).getMapAsync(new dis_rescue(o));
        }
    }

}
