package com.example.paolo.transactionornotransaction;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainGameActivity extends AppCompatActivity {
    Banker banker;
    int maxmoney=1000000;
    int numcases=18;
    int[] money_values = {1, 5, 25, 50, 100, 200, 350, 500, 750, 1000, 10000, 25000, 50000, 100000, 300000, 500000, 750000, 1000000};
    int[] money_cases;
    boolean[] case_already_picked;
    boolean playercaseselected = false;
    int playercase;
    int casesleft=numcases;

    int maxcasepicks=numcases/4;
    int picks=maxcasepicks;
    int[] casepicks;
    int round=0;

    ImageView your_case;
    TextView[] money_plaques;
    ImageButton[] case_buttons;
    TextView pickcounter;

    /*
    This is the main Game Activity
    This Screen would show Buttons as the
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        banker = new Banker();
        case_buttons = new ImageButton[18];
        money_plaques = new TextView[18];
        money_cases = new int[18];
        case_already_picked = new boolean[18];
        casepicks = new int[maxcasepicks];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        pickcounter = findViewById(R.id.numpicks_tv);
        pickcounter.setText("Select Your Case");

        your_case = findViewById(R.id.your_case_view);

        case_buttons[0]=findViewById(R.id.CaseButton1);
        case_buttons[1]=findViewById(R.id.CaseButton2);
        case_buttons[2]=findViewById(R.id.CaseButton3);
        case_buttons[3]=findViewById(R.id.CaseButton4);
        case_buttons[4]=findViewById(R.id.CaseButton5);
        case_buttons[5]=findViewById(R.id.CaseButton6);
        case_buttons[6]=findViewById(R.id.CaseButton7);
        case_buttons[7]=findViewById(R.id.CaseButton8);
        case_buttons[8]=findViewById(R.id.CaseButton9);
        case_buttons[9]=findViewById(R.id.CaseButton10);
        case_buttons[10]=findViewById(R.id.CaseButton11);
        case_buttons[11]=findViewById(R.id.CaseButton12);
        case_buttons[12]=findViewById(R.id.CaseButton13);
        case_buttons[13]=findViewById(R.id.CaseButton14);
        case_buttons[14]=findViewById(R.id.CaseButton15);
        case_buttons[15]=findViewById(R.id.CaseButton16);
        case_buttons[16]=findViewById(R.id.CaseButton17);
        case_buttons[17]=findViewById(R.id.CaseButton18);

        money_plaques[0] = findViewById(R.id.money_textview1);
        money_plaques[1] = findViewById(R.id.money_textview2);
        money_plaques[2] = findViewById(R.id.money_textview3);
        money_plaques[3] = findViewById(R.id.money_textview4);
        money_plaques[4] = findViewById(R.id.money_textview5);
        money_plaques[5] = findViewById(R.id.money_textview6);
        money_plaques[6] = findViewById(R.id.money_textview7);
        money_plaques[7] = findViewById(R.id.money_textview8);
        money_plaques[8] = findViewById(R.id.money_textview9);
        money_plaques[9] = findViewById(R.id.money_textview10);
        money_plaques[10] = findViewById(R.id.money_textview11);
        money_plaques[11] = findViewById(R.id.money_textview12);
        money_plaques[12] = findViewById(R.id.money_textview13);
        money_plaques[13] = findViewById(R.id.money_textview14);
        money_plaques[14] = findViewById(R.id.money_textview15);
        money_plaques[15] = findViewById(R.id.money_textview16);
        money_plaques[16] = findViewById(R.id.money_textview17);
        money_plaques[17] = findViewById(R.id.money_textview18);

        for(int i=0; i<money_plaques.length; i++){
            money_plaques[i].setText(Integer.toString(money_values[i]));
            //money_cases[i]=i;
        }

        initGameCases();
    }

    /*
    This would be the onClick method for all the suitcases
    in the GUI.
     */
    public void caseClick(View view){
        casesleft--;

        int caseindex=0;
        for(int i=0; i<numcases; i++){
            if(case_buttons[i] == (ImageButton)view){
                caseindex=i;
                break;
            }
        }



        if(!playercaseselected){
            playercase=caseindex;
            case_buttons[caseindex].setEnabled(false);
            case_buttons[caseindex].setVisibility(View.INVISIBLE);
            playercaseselected=true;
            pickcounter.setText("Select " + (maxcasepicks-round)+" cases");
            your_case.setImageDrawable(case_buttons[caseindex].getDrawable());
            return;
        }

        if(picks>0) {
            //Toast.makeText(this, "Case: "+(caseindex)+" moneyindex: "+money_cases[caseindex], Toast.LENGTH_SHORT).show();
            case_buttons[caseindex].setEnabled(false);
            case_buttons[caseindex].setVisibility(View.INVISIBLE);
            money_plaques[money_cases[caseindex]].setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            money_plaques[money_cases[caseindex]].setTextColor(getResources().getColor(R.color.dark_gold));
            casepicks[picks-1] = money_values[money_cases[caseindex]];
            picks--;
        }
        if(picks==0){
            /*try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //int offer = banker.getOffer(casepicks);
            //Toast.makeText(this, "Banker Makes his offer", Toast.LENGTH_SHORT).show();
            if(round>=maxcasepicks) {
                casepicks = new int[1];
                picks=1;
            }
            else {
                casepicks = new int[maxcasepicks - round];
                picks=maxcasepicks-round;
            }

            round++;
        }
        pickcounter.setText("Select " + (picks)+" cases");

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
        for(int i=0; i<case_already_picked.length; i++){
            case_already_picked[i]=false;
        }
        Random rand = new Random();
        int random;
        for(int i=0; i<money_cases.length; i++){
            do{
                random = rand.nextInt(numcases);
                //System.out.println("Random: "+random);

                //System.out.println("Case "+ (i)+": "+money_cases[i]);

            }while(case_already_picked[random]);
            money_cases[i] = random;
            case_already_picked[random]=true;
        }
        /*for(int i=0; i<money_cases.length;i++){
            money_cases[i]=i;
        }*/
    }
}
