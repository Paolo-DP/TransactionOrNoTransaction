package com.example.paolo.transactionornotransaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainGameActivity extends AppCompatActivity {
    int maxmoney=1000000;
    int numcases=10;
    int[] money_values;
    int[] money_cases;
    boolean[] case_already_picked;

    int maxcasepicks=numcases/4;
    int picks=0;
    int round=0;

    /*
    This is the main Game Activity
    This Screen would show Buttons as the
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

    }

    /*
    This would be the onClick method for all the suitcases
    in the GUI.
     */
    public void caseClick(View view){

        if(picks>(maxcasepicks-round))
            picks++;
        else{
            picks=0;
            round++;
        }
    }

    public boolean[] getAlreadyPickedCases(){
        return null;
    }

    /*
    returns an array of the money values the contestant
    picked during a round
     */
    public int[] getRoundMoneyPicks(){
        return null;
    }

    /*
    returns an array of all the Money vales still
    available on the board
     */
    public int[] getRemainingCaseValues(){
        return null;
    }

    private void initGameCases(){
        double basemoney = maxmoney/(Math.pow(2,numcases-1));
        money_cases = new int[numcases];
        money_values = new int[numcases];
        case_already_picked = new boolean[numcases];
        //System.out.println("Money Values:");
        for(int i=0; i<numcases; i++){
            money_values[i] = (int)(basemoney*Math.pow(2,i));
            money_cases[i]=0;
            case_already_picked[i]=true;
            //System.out.println(money_values[i]);
        }
        int random;
        for(int i=numcases-1; i>=0; i--){
            do{
                random = (int) (Math.random() * (numcases));
                //System.out.println("Random: "+random);
                if(case_already_picked[random]){
                    money_cases[i] = money_values[random];
                    case_already_picked[random]=false;
                    //System.out.println("Case "+ (i)+": "+money_cases[i]);
                }
            }while(case_already_picked[random]);
        }
    }

}
