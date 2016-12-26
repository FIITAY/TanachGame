package itay.finci.org.biblegame;

import android.content.Context;

/**
 * Created by itay on 26/12/16.
 */
public class truefalseTable {
    private static truefalseTable ourInstance = new truefalseTable();
    private truefalse[] truefalses;
    private static boolean firstTime = true;

    public static truefalseTable getInstance(Context ctx) {
        if (firstTime) {
            ourInstance.truefalses = new truefalse[2];
            ourInstance.truefalses[0] = new truefalse("true", true);
            ourInstance.truefalses[1] = new truefalse("false", false);
            //TODO make the questions
            firstTime = false;
        }
        return ourInstance;
    }

    private truefalseTable(){
    }

    public truefalse getTrueFalse(int i){
        return truefalses[i];
    }

    public int numOfElements(){
        return truefalses.length;
    }
}
