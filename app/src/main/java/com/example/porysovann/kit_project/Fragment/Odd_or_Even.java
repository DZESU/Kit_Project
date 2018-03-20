package com.example.porysovann.kit_project.Fragment;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.porysovann.kit_project.Activity.Lost_Activity;
import com.example.porysovann.kit_project.Activity.Main_Activity;
import com.example.porysovann.kit_project.Game.Game_Propety;
import com.example.porysovann.kit_project.R;

import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * A simple {@link Fragment} subclass.
 */
public class Odd_or_Even extends Fragment {

    Random random;
    TextView txt_random;
    boolean answer;
    boolean result;
    int iRandom;
    ImageView odd;
    ImageView even;
//    Fragment[] gameChoice = new Fragment[2];
    Game_Propety game_propety;
    CountDownTimer countDownTimer;
    public Odd_or_Even() {
        // Required empty public constructor
        game_propety = new Game_Propety();
        game_propety.isAlive = true;
        game_propety.moveOn = false;

        random = new Random();
        iRandom = abs(random.nextInt()%800+100);
        result = iRandom%2==0;


    }

    private void Checker(){
//        gameChoice[0]= new ture_or_false();
//        gameChoice[1]= new bigger_or_smaller();
        if(answer == result){
            //txt_random.setText("Correct");
            game_propety.score++;
            game_propety.moveOn = true;
            game_propety.isAlive=true;
            game_propety.timer[2]= game_propety.timer[2];
        //    onGameMove(Math.abs(random.nextInt()%2));
        }
        else{
            txt_random.setText("Lose");
            game_propety.isAlive = false;
            game_propety.moveOn = false;
        }


    }

//    public  void onGameMove(int i){
//        //countDownTimer.cancel();
//        final int index = i ;
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run(){
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.lyt_playfilde,gameChoice[index]);
//                //fragmentTransaction.remove(fragmentManager.findFragmentById(R.id.oddeven));
//                fragmentTransaction.commit();
//            }
//        },600);
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_odd_or__even, container, false);
        txt_random = (TextView) view.findViewById(R.id.txt_random);
        txt_random.setText(iRandom+"");
        odd = (ImageView)view.findViewById(R.id.btn_odd);
        even = (ImageView)view.findViewById(R.id.btn_even);
//
//        countDownTimer = new CountDownTimer(5*1000,100) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                if(game_propety.isAlive==false){
//                    Log.d("pory","onTick");
//                    cancel();
//                    GameOver();
//                }
//                if (game_propety.moveOn == true)
//                    cancel();
//
//                Log.d("odd even", millisUntilFinished+"");
//            }
//
//            @Override
//            public void onFinish() {
//
//
//                Log.d("pory","onFinsih");
//                GameOver();
//            }
//        };

        odd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OddClicked();
                    }
                }
        );

        even.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EvenClicked();
                    }
                }
        );


//         countDownTimer.start();
        return view;
    }
//    private void GameOver(){
//        //countDownTimer.cancel();
//        Intent intent = new Intent(getActivity(),Lost_Activity.class);
//        startActivity(intent);
//        getActivity().finish();
//    }


    private void OddClicked(){
        answer = false;
        Checker();
    }
    private void EvenClicked(){
        answer = true;
        Checker();
    }


}
