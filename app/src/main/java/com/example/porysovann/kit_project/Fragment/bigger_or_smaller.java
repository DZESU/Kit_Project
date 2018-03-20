package com.example.porysovann.kit_project.Fragment;


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
import com.example.porysovann.kit_project.Game.Game_Propety;
import com.example.porysovann.kit_project.R;

import java.util.Random;

import static java.lang.Math.abs;

/**
 * A simple {@link Fragment} subclass.
 */
public class bigger_or_smaller extends Fragment {


    //CountDownTimer countDownTimer;
    TextView txt_random;
    ImageView big;
    ImageView small;
    int firstNumber;
    int seconNumber;
    boolean answer;
    boolean result;
    Random random = new Random();

//    Fragment[] gameChoice = new Fragment[2];
    Game_Propety game_propety;

    public bigger_or_smaller() {
        // Required empty public constructor
        game_propety = new Game_Propety();
        game_propety.isAlive = true;
        game_propety.moveOn = false;

        firstNumber = abs(random.nextInt()%89+10);
        seconNumber= abs(random.nextInt()%89+10);
        while (firstNumber == seconNumber ){
            seconNumber = abs(random.nextInt()%89+10);
        }
        result = true;

    }

    private void Checker() {
//        gameChoice[0]= new Odd_or_Even();
//        gameChoice[1]= new ture_or_false();
        if (result == answer) {
            //txt_random.setText("Correct");
            game_propety.score++;
            //game_propety.timer[2]= game_propety.timer[2];
            game_propety.isAlive=true;
            game_propety.moveOn = true;
            //onGameMove(Math.abs(random.nextInt()%2));
        } else {
            txt_random.setText("Lose");
            game_propety.isAlive = false;
            game_propety.moveOn = false;
        }
    }
//
//    public  void onGameMove(int i){
//
//       // countDownTimer.cancel();
//        final int index = i ;
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run(){
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.lyt_playfilde,gameChoice[index]);
//                fragmentTransaction.commit();
//            }
//        },600);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bigger_or_smaller, container, false);

        txt_random = (TextView) view.findViewById(R.id.txt_random);
        txt_random.setText(firstNumber+" ? "+seconNumber);
        big = (ImageView) view.findViewById(R.id.btn_big);
        small = (ImageView) view.findViewById(R.id.btn_small);

//        countDownTimer = new CountDownTimer(5*1000,100) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                if(game_propety.isAlive==false){
//                    Log.d("pory","onFinsih");
//                    cancel();
//                    GameOver();
//                }
//                if(game_propety.moveOn = true)
//                    cancel();
//
//                Log.d("big or small", millisUntilFinished+"");
//            }
//
//            @Override
//            public void onFinish() {
//                Log.d("pory","onFinsih");
//                GameOver();
//
//            }
//        };

        big.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BigClicked();
                    }
                }
        );
        small.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SmallClicked();
                    }
                }
        );
//        countDownTimer.start();
        return view;
    }

    private void GameOver(){
            //countDownTimer.cancel();
            Intent intent = new Intent(getActivity(), Lost_Activity.class);
            startActivity(intent);
            getActivity().finish();

    }

    private void BigClicked(){
        answer = firstNumber>seconNumber;
        Checker();

    }
    private void SmallClicked(){
        answer = firstNumber<seconNumber;
        Checker();

    }
}
