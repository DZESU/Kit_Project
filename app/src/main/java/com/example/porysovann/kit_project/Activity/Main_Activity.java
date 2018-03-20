package com.example.porysovann.kit_project.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.porysovann.kit_project.Fragment.Odd_or_Even;
import com.example.porysovann.kit_project.Fragment.bigger_or_smaller;
import com.example.porysovann.kit_project.Fragment.ture_or_false;
import com.example.porysovann.kit_project.Game.Game_Propety;
import com.example.porysovann.kit_project.R;

import java.util.Random;

public class Main_Activity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    TextView txt_score;
    Game_Propety game_propety;
    Fragment[] gameIndex;
    int temp;
    Random rand;
    SeekBar timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Log.d("Array","inital");

        temp =-1;
        int time = 3*1000;
        rand = new Random();
        txt_score = (TextView)findViewById(R.id.txt_score);
        game_propety = new Game_Propety();
        game_propety.isAlive = true;
        game_propety.score = 0;
        game_propety.moveOn = false;
        txt_score.setText(""+Game_Propety.score);
        timer = (SeekBar)findViewById(R.id.timer);
        timer.setMax(time);
        //GameOver();
        //int indexGame = Math.abs(rand.nextInt()%3);
       // ToF();
        //StartGame(indexGame);

        countDownTimer= new CountDownTimer(time,10) {
            @Override
            public void onTick(long millisUntilFinished) {
               // Log.d("pory",millisUntilFinished+"");
                timer.setProgress((int)millisUntilFinished);
                if(game_propety.isAlive==false){

                    GameOver();
                    cancel();
                    Log.d("hello","canceled");
                }
                if(game_propety.moveOn == true){
                    cancel();
                    onGameMove();

                    game_propety.moveOn = false;

                }
               // Log.d("hello","restart");

            }
            @Override
            public void onFinish() {
                Log.d("hello","world");
               GameOver();
            }
        };
        onGameMove();
        countDownTimer.start();
    }

    private void onGameMove() {
        countDownTimer.start();
        gameIndex = null;
        gameIndex = new Fragment[3];
        gameIndex[0] = new Odd_or_Even();
        Log.d("Array","0");
        gameIndex[1] = new bigger_or_smaller();
        Log.d("Array","1");
        gameIndex[2] = new ture_or_false();
        Log.d("Array","2");

        int i = Math.abs(rand.nextInt() % 3);
        txt_score.setText(game_propety.score+"");
        if (temp != i){
            Log.d("int i ", i + "");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lyt_playfilde, gameIndex[i]);
        fragmentTransaction.commit();
            temp = i;
        }else onGameMove();

    }

//
//    private void Timer(){
//        if(game_propety.isAlive){
//           // game_propety.isAlive=true;
//            countDownTimer.cancel();
//            countDownTimer.start();
//            Log.d("pory","timer Start");
//        }
//        else
//        {
//            countDownTimer.cancel();
//
//        }
//    }
    private void GameOver(){

        Intent intent = new Intent(this,Lost_Activity.class);
        startActivity(intent);
        finish();
    }
//
//    private void StartGame(int i){
//        switch (i){
//            case 0:
//                BoS();
//                break;
//            case 1:
//                ToF();
//                break;
//            case 2:
//                OoE();
//                break;
//            case 3:
//                BoS();
//                Log.d("ee","eee");
//                break;
//        }
//    }
//
//    private void BoS(){
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        bigger_or_smaller biggerOrSmaller = new bigger_or_smaller();
//        fragmentTransaction.replace(R.id.lyt_playfilde,biggerOrSmaller);
//        fragmentTransaction.commit();
//    }
//    private void OoE(){
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        Odd_or_Even odd_or_even = new Odd_or_Even();
//        fragmentTransaction.replace(R.id.lyt_playfilde,odd_or_even);
//        fragmentTransaction.commit();
//    }
//    private void ToF(){
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        ture_or_false tureOrFalse = new ture_or_false();
//        fragmentTransaction.replace(R.id.lyt_playfilde,tureOrFalse);
//        fragmentTransaction.commit();
//    }


}


