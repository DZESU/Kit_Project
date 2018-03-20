package com.example.porysovann.kit_project.Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
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
public class ture_or_false extends Fragment{


    //Member variables
    TextView txt_random;
    ImageView truee;
    ImageView falsee;
    int iAnswer;
    int firstNumber;
    int secondNumber;
    int thirtNumber;
    int randomOperator;
    char operator;
    boolean result;
    boolean answer;
    int[] thirdList = new int[5];
    Random random;
//    Fragment[] gameChoice = new Fragment[2];
    Game_Propety game_propety;
    CountDownTimer countDownTimer;
    public ture_or_false() {
        // Required empty public constructor
        random = new Random();
        game_propety = new Game_Propety();
        game_propety.isAlive = true;
        game_propety.moveOn = false;
        firstNumber = abs(random.nextInt())%20+25;
        secondNumber = abs(random.nextInt())%10+15;
        Randomoperator();
        thirdList[0]= iAnswer-2;
        thirdList[1]= iAnswer-1;
        thirdList[2]= iAnswer;
        thirdList[3]= iAnswer+1;
        thirdList[4]= iAnswer+2;

        thirtNumber = thirdList[abs(random.nextInt()%5)];
        result= firstNumber+secondNumber==thirtNumber;

    }

    private void Checker(){
//        gameChoice[0]= new Odd_or_Even();
//        gameChoice[1]= new bigger_or_smaller();

        if(result==answer){
            //txt_random.setText("Correct");
            game_propety.score++;
            game_propety.isAlive = true;
            game_propety.moveOn = true;
            //game_propety.timer[2]= game_propety.timer[2];
            //onGameMove(Math.abs(random.nextInt()%2));
        }
        else if(result != answer) {
            game_propety.isAlive = false;
            game_propety.moveOn = false;
            txt_random.setText("Lose");
        }
    }

//    public  void onGameMove(int i){
//       // countDownTimer.cancel();
//        final int index = i ;
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run(){
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.lyt_playfilde,gameChoice[index]);
//                //fragmentTransaction.remove(fragmentManager.findFragmentById(R.id.turefalse));
//                fragmentTransaction.commit();
//            }
//        },600);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ture_or_false, container, false);

        txt_random = (TextView)view.findViewById(R.id.txt_random);
        truee = (ImageView)view.findViewById(R.id.btn_ture);
        falsee = (ImageView)view.findViewById(R.id.btn_false);
        String txt = firstNumber+""+operator+""+secondNumber+"="+thirtNumber+"";

        txt_random.setText(txt);

//        countDownTimer = new CountDownTimer(5*1000,100) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                if(game_propety.isAlive==false){
//                    Log.d("pory","onTick");
//                    cancel();
//                    GameOver();
////                    cancel();
//                }
//                if (game_propety.moveOn == true)
//                    //cancel();
//                Log.d("ture or false", millisUntilFinished+"");
//            }
//
//            @Override
//            public void onFinish() {
//                Log.d("pory","onFinsih");
//                GameOver();
//            }
//        };

        truee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TureClicked();
                        Checker();
                    }
                }
        );

        falsee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FalseClicked();
                        Checker();
                    }
                }
        );

        //countDownTimer.start();

        return view;
    }
    private void GameOver(){

        //countDownTimer.cancel();
        Intent intent = new Intent(getActivity(), Lost_Activity.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void TureClicked(){
        answer = true;
    }

    private void FalseClicked(){
        answer = false;
    }

    private void Randomoperator(){

        randomOperator = abs(random.nextInt()%2);
        switch (randomOperator){
            case 0:
                iAnswer = firstNumber-secondNumber;
                operator = '-';
                break;
            case 1:
                iAnswer = firstNumber+secondNumber;
                operator = '+';
                break;

        }

    }
}
