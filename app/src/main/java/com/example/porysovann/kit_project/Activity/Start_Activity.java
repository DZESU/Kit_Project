package com.example.porysovann.kit_project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.porysovann.kit_project.R;

/**
 * Created by Pory Sovann on 5/19/2017.
 */

public class Start_Activity extends AppCompatActivity implements View.OnClickListener {

    TextView btn_start;
    ImageView img_start;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //startHomeActivity();
                //finish();
        setContentView(R.layout.start_activirty_new);
            }
        },4000);

       // btn_start = (TextView) findViewById(R.id.btn_start);

        img_start= (ImageView) findViewById(R.id.btn_start);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_start){
            Intent intent = new Intent(this,Main_Activity.class);
            startActivity(intent);

        }
    }
}
