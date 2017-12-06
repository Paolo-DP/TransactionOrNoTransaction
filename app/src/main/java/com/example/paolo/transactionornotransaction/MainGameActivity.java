package com.example.paolo.transactionornotransaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainGameActivity extends AppCompatActivity {
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

}
