package com.example.porysovann.kit_project.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.porysovann.kit_project.Game.Game_Propety;
import com.example.porysovann.kit_project.R;

/**
 * Created by Pory Sovann on 6/13/2017.
 */

public class Lost_Activity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt("HIGH_SCORE",Game_Propety.highScore);


        setContentView(R.layout.lost_activity_new);
        int highscore= sharedPref.getInt("HIGH_SCORE",0);
        int score = Game_Propety.score;
        Log.d("Hi score",highscore+"");
        if(score>highscore){
            editor.putInt("HIGH_SCORE",score);
            editor.apply();
            highscore = score;
        }

        ImageView btn_try_again = (ImageView)findViewById(R.id.btn_try_again);
        btn_try_again.setOnClickListener(this);
        TextView txt_score = (TextView)findViewById(R.id.txt_score);
        TextView txt_highScore= (TextView)findViewById(R.id.txt_highscore);
        txt_highScore.setText(highscore+"");
        txt_score.setText(Game_Propety.score+"");

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_try_again){
            Intent intent = new Intent(this,Main_Activity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
