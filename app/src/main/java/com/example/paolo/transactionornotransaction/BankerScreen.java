package com.example.paolo.transactionornotransaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Math.sqrt;

public class BankerScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banker_screen);
        Intent i = getIntent();
        Bundle b = new Bundle();
        b = i.getExtras();
        int[] clos = new int[18];
        clos = b.getIntArray("Enter array key");
        int rez = getOffer(clos);
        TextView res = (TextView)findViewById(R.id.result);
        String rec = String.valueOf(rez);
        res.setText("$"+rec);
    }
    public void dont(View view){
        finish();
    }
    public void notdont(View view){

    }
    public int getOffer(int[] casepicks){

        int[] closed = {1,5,25,50,100,200,350,500,750,1000,10000,25000,50000,100000,300000,500000,750000,1000000};
        for(int i=0;i<closed.length;i++){
            for(int j=0;j<casepicks.length;j++){
                if(closed[i]==casepicks[j])
                    closed[i]=0;
            }
        }
        double total = 0;
        int cases = 0;
        double random = new Random().nextDouble();
        double randomVal = 0.2 + (random * 0.3);
        for(int i=0; i<closed.length; i++){
            if(closed[i]!=0){
                total += Math.pow(closed[i],2);
                cases++;
            }
        }
        return (int)(((0.6 + randomVal) * Math.sqrt(total/cases))/100)*100;
    }
}
