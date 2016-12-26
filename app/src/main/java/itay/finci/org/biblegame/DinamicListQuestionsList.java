package itay.finci.org.biblegame;

import android.content.Context;

/**
 * Created by itay on 26/12/16.
 */
public class DinamicListQuestionsList {
    private static DinamicListQuestionsList ourInstance = new DinamicListQuestionsList();

    private DinamicListQuestions[] dlqt;
    private static boolean firstTime = true;

    public static DinamicListQuestionsList getInstance(Context ctx) {
        if (firstTime) {
            ourInstance.dlqt  = new DinamicListQuestions[2];
            ourInstance.dlqt[0] = new DinamicListQuestions("the answer is 1","1","2","3","4");
            ourInstance.dlqt[1] = new DinamicListQuestions("the answer is 1","1","2","3","5");
            //TODO make the questions
            firstTime = false;
        }
        return ourInstance;
    }

    private DinamicListQuestionsList() {
    }

    public int getNumElements(){
        return dlqt.length;
    }

    public DinamicListQuestions getElement(int place){
        return dlqt[place];
    }
}
