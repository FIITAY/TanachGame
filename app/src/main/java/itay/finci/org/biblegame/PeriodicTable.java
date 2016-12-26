package itay.finci.org.biblegame;

import android.content.Context;

/**
 * Created by itay on 17/09/16.
 */
public class PeriodicTable {
    private static PeriodicTable ourInstance = new PeriodicTable();
    private Periodic[] periodic;
    private static boolean firstTime = true;

    public static PeriodicTable getInstance(Context ctx) {
        if (firstTime) {
            ourInstance.periodic  = new Periodic[2];
            ourInstance.periodic[0] = new Periodic("the answer is 1","1","2","3","4");
            ourInstance.periodic[1] = new Periodic("the answer is 1","1","2","3","5");
            //TODO make the questions
            firstTime = false;
        }
            return ourInstance;
    }

    private PeriodicTable() {
    }

    public Periodic getPeriodic(int place) {
        return periodic[place];
    }
    public int getNumElements(){
        return periodic.length;
    }
}
