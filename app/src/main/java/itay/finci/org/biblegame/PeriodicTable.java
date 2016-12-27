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
            ourInstance.periodic  = new Periodic[6];
            ourInstance.periodic[0] = new Periodic("היכן היתה המלחמה האחרונה של שאול ויהונתן בפלשתים?","הר הגלבוע","עמק האלה","יריחו","גבעת החכילה");
            ourInstance.periodic[1] = new Periodic("כיצד מת שאול?","נפל על חרבו ומת","במלחמה בפלשתים צלפים ירו בו חץ","נושא כליו הרג אותו בחרבו","אף תשובה נכונה");
            ourInstance.periodic[2] = new Periodic("מה עשה נושא כליו של שאול במלחמה בפלשתים?","נפל על חרבו ומת" , "דקר את שאול בחרב כפי שביקש ממנו שאול","קרע את בגדיו כשראה ששאול מת" , "וַיָנָס בְּרַ גְּלָיו");
            ourInstance.periodic[3] = new Periodic("מה עשו הפלשתים לגופתו של שאול ובניו?","כל התשובות נכונות","כרתו את ראשם","הפשיטו אותם","תקעו אותם בחומה");
            ourInstance.periodic[4] = new Periodic("מי קבר את שאול ואת בניו","יושבי יבש גלעד","הפלשתים שהתעללו בגופות","אף אחד","דוד המלך ואנשיו");
            ourInstance.periodic[5] = new Periodic("מי אמר למי: \"וּדְקָרֻנִי וְהִתְעַלְּלוּ-בִי\"","שאול לנושא כליו","נושא כליו של שאול לשאול","דוד ליונתן","שאול לנער העמלקי");

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
