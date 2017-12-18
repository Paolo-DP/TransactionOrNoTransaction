package com.example.paolo.transactionornotransaction;

import java.util.Random;

import static java.lang.Math.sqrt;

/**
 * Created by Paolo on 05/12/2017.
 */

public class Banker {
    /*
    This method will return the value of the Banker's offer
    based on the previous picks as well as the
    remaining cases
     */

    public int getOffer(int[] casepicks){

        double total = 0;
        int cases = 0;
        double random = new Random().nextDouble();
        double randomVal = 0.2 + (random * 0.3);
        for(int i=0; i<casepicks.length; i++){
            if(casepicks[i]!=0){
                total += Math.pow(casepicks[i],2);
                cases++;
            }
        }
        if (cases >= 25)
            return (int)((0.1 + randomVal) * sqrt(total/cases));
        else if (cases > 19)
            return (int) ((0.2 + randomVal) * sqrt(total/cases));
        else if (cases > 14)
            return (int)((0.3 + randomVal) * sqrt(total/cases));
        else
            return (int)((0.6 + randomVal) * sqrt(total/cases));
    }

    /*
    The main game activity will pass the list of
     */

}

