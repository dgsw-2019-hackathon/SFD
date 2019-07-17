package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jsoup.Jsoup;

import java.io.IOException;


public class dis_info extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dis_info);
        new DownloadFilesTask().execute();
    }

    @Override
    public void onMapReady(final GoogleMap map) {

    }

    public void dis_info_bt(View v) {
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

    class fir implements OnMapReadyCallback{

        String name;
        String content;
        double lat;
        double lon;

        fir(String name, String content,String lat,  String lon){
            this.name = name;
            this.content = content;
            this.lat = Double.parseDouble(lat);
            this.lon = Double.parseDouble(lon);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng SEOUL = new LatLng(lon, lat);
            Log.e("e",Double.toString(lat));
            Log.e("e",Double.toString(lon));
            MarkerOptions markerOptions = new MarkerOptions();
            CircleOptions circle1KM = new CircleOptions().center(SEOUL) //원점
                    .radius(1000)      //반지름 단위 : m
                    .strokeWidth(0f)  //선너비 0f : 선없음
                    .fillColor(Color.parseColor("#880000ff")); //배경색
            googleMap.addCircle(circle1KM);
            markerOptions.position(SEOUL);
            markerOptions.title(name);
            markerOptions.snippet(content);
            googleMap.addMarker(markerOptions);

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        }
    }

    class sec implements OnMapReadyCallback{

        String name;
        String content;
        double lat;
        double lon;

        sec(String name, String content,String lat,  String lon){
            this.name = name;
            this.content = content;
            this.lat = Double.parseDouble(lat);
            this.lon = Double.parseDouble(lon);
        }
        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng SEOUL = new LatLng(lon, lat);
            Log.e("e",Double.toString(lat));
            Log.e("e",Double.toString(lon));
            MarkerOptions markerOptions = new MarkerOptions();
            CircleOptions circle1KM = new CircleOptions().center(SEOUL) //원점
                    .radius(1000)      //반지름 단위 : m
                    .strokeWidth(0f)  //선너비 0f : 선없음
                    .fillColor(Color.parseColor("#880000ff")); //배경색
            googleMap.addCircle(circle1KM);
            markerOptions.position(SEOUL);
            markerOptions.title(name);
            markerOptions.snippet(content);
            googleMap.addMarker(markerOptions);

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(8));
        }

    }

    class thr implements OnMapReadyCallback{

        String name;
        String content;
        double lat;
        double lon;

        thr(String name, String content,String lat,  String lon){
            this.name = name;
            this.content = content;
            this.lat = Double.parseDouble(lat);
            this.lon = Double.parseDouble(lon);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng SEOUL = new LatLng(lon, lat);
            Log.e("e",Double.toString(lat));
            Log.e("e",Double.toString(lon));
            MarkerOptions markerOptions = new MarkerOptions();
            CircleOptions circle1KM = new CircleOptions().center(SEOUL) //원점
                    .radius(1000)      //반지름 단위 : m
                    .strokeWidth(0f)  //선너비 0f : 선없음
                    .fillColor(Color.parseColor("#880000ff")); //배경색
            googleMap.addCircle(circle1KM);
            markerOptions.position(SEOUL);
            markerOptions.title(name);
            markerOptions.snippet(content);
            googleMap.addMarker(markerOptions);

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(8));
        }

    }

    class four implements OnMapReadyCallback{

        String name;
        String content;
        double lat;
        double lon;

        four(String name, String content,String lat,  String lon){
            this.name = name;
            this.content = content;
            this.lat = Double.parseDouble(lat);
            this.lon = Double.parseDouble(lon);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng SEOUL = new LatLng(lon, lat);
            Log.e("e",Double.toString(lat));
            Log.e("e",Double.toString(lon));
            MarkerOptions markerOptions = new MarkerOptions();
            CircleOptions circle1KM = new CircleOptions().center(SEOUL) //원점
                    .radius(1000)      //반지름 단위 : m
                    .strokeWidth(0f)  //선너비 0f : 선없음
                    .fillColor(Color.parseColor("#880000ff")); //배경색
            googleMap.addCircle(circle1KM);
            markerOptions.position(SEOUL);
            markerOptions.title(name);
            markerOptions.snippet(content);
            googleMap.addMarker(markerOptions);

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(8));
        }

    }


    class DownloadFilesTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            JsonArray jsonArray = null;
            try {
                String jsonStr = Jsoup.connect(DATA.IP+"/news/")
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
            JsonObject object = null;
            object =  (JsonObject) ((JsonArray)o).get(0);
            ((MapFragment)getFragmentManager()
                    .findFragmentById(R.id.map)).getMapAsync(new fir(( object).get("title").getAsString(), ( object).get("content").getAsString(),( object).get("latitude").getAsString(),(object).get("longitude").getAsString()));
            ((TextView) findViewById(R.id.textView13)).setText(( object).get("title").getAsString());
            ((TextView) findViewById(R.id.textView14)).setText(( object).get("content").getAsString());
            object =  (JsonObject) ((JsonArray)o).get(1);
            ((MapFragment)getFragmentManager()
                    .findFragmentById(R.id.map2)).getMapAsync(new sec(( object).get("title").getAsString(), ( object).get("content").getAsString(),( object).get("latitude").getAsString(),(object).get("longitude").getAsString()));
            ((TextView) findViewById(R.id.textView9)).setText(( object).get("content").getAsString());
            object =  (JsonObject) ((JsonArray)o).get(2);
            ((MapFragment)getFragmentManager()
                    .findFragmentById(R.id.map3)).getMapAsync(new thr(( object).get("title").getAsString(), ( object).get("content").getAsString(),( object).get("latitude").getAsString(),(object).get("longitude").getAsString()));
            ((TextView) findViewById(R.id.textView11)).setText(( object).get("content").getAsString());
            object =  (JsonObject) ((JsonArray)o).get(3);
            ((MapFragment)getFragmentManager()
                    .findFragmentById(R.id.map4)).getMapAsync(new four(( object).get("title").getAsString(), ( object).get("content").getAsString(),( object).get("latitude").getAsString(),(object).get("longitude").getAsString()));
            ((TextView) findViewById(R.id.textView12)).setText(( object).get("content").getAsString());
        }
    }

}
