package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jsoup.Jsoup;
import java.io.IOException;

public class dis_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dis_main);
        new DownloadFilesTask().execute();
    }

    public void dis_main_bt(View v) {
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
            JsonObject object = null;
            try {
                String jsonStr = Jsoup.connect(DATA.IP+"/fire/")
                        .timeout(4000)
                        .userAgent("Mozilla")
                        .ignoreContentType(true)
                        .execute().body();
                    Log.e("e",jsonStr);
                JsonParser Parser = new JsonParser();
                JsonArray jsonArray = (JsonArray) Parser.parse("["+jsonStr+"]");
                object = (JsonObject) jsonArray.get(0);
                Log.e("e",object.get("receive").getAsString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return Boolean.valueOf(object.get("receive").getAsString());
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if((Boolean) o){
                ((ImageView) findViewById(R.id.imageView)).setImageResource(R.drawable.warning);
                ((TextView) findViewById(R.id.textView8)).setText("재난발생!");
            }
        }
    }

}
