package com.example.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;

public class dis_way extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dis_way);
        TextView textView = (TextView) findViewById(R.id.textView10);
        textView.setMovementMethod(new ScrollingMovementMethod());

    }

    public void dis_way_bt(View v) {
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
}
