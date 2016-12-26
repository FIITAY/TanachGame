package itay.finci.org.biblegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GamePart3 extends AppCompatActivity {

    int firstTry, secondTry, dontSeccede;
    DinamicListQuestions[] dlqt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        firstTry= b.getInt("IN_FIRST_TRY");
        secondTry =b.getInt("IN_SECOND_TRY");
        dontSeccede = b.getInt("DIDNT_SECCEDE");

    }

    int amountofclicks,roundNum;

    @Override
    protected void onStart() {
        super.onStart();
        dlqt = new DinamicListQuestions[DinamicListQuestionsList.getInstance(getApplicationContext()).getNumElements()];
        for (int i = 0; i < dlqt.length; i++) {
            dlqt[i] = new DinamicListQuestions(DinamicListQuestionsList.getInstance(getApplicationContext()).getElement(i));
        }
        amountofclicks=0; roundNum=0;

    }

    private void act(){
        if(roundNum == dlqt.length){
            Intent intent = new Intent(getApplicationContext() , Results.class);
            intent.putExtra("IN_FIRST_TRY" , firstTry);
            intent.putExtra("IN_SECOND_TRY", secondTry);
            intent.putExtra("DIDNT_SECCEDE", dontSeccede);
            startActivity(intent);
            return;
        }
        
    }
}
