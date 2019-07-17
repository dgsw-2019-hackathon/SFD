package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class dis_sig extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dis_sig);
    }

    public void dis_sig_bt(View v) {
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
            case R.id.imageView4:
                new DownloadFilesTask(this).execute();
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

        DownloadFilesTask(Activity activity){
            this.activity = activity;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                //연결
                URL url = new URL("http://192.168.137.221:1278/api2/rescue/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Language",  "ko-kr,ko;q=0.8,en-us;q=0.5,en;q=0.3");

                //데이터
                String param = URLEncoder.encode("receive", "UTF-8") + "=" + URLEncoder.encode("true", "UTF-8");
                param += "&" + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode("10.1", "UTF-8");
                param += "&" + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode("10.4", "UTF-8");
                //전송
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                osw.write(param);
                osw.flush();

                //응답
                BufferedReader br = null;
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

                //닫기
                osw.close();
                br.close();
            } catch (Exception e){
                return false;
            }

            return true;

        }

        Activity activity;



        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if((Boolean) o){
                Toast.makeText(activity,"전송완료",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity,"전송실패",Toast.LENGTH_SHORT).show();
            }

        }
    }

}
