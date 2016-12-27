package itay.finci.org.biblegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {

    int roundNum;
    final static int MAX_ROUNDS = 10;
    PeriodicTable periodicTable;
    Periodic[] periodic ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    Random random;
    int truebutton;
    int amountofclicks;
    TextView tvTheGiven;
    Button btOption1, btOption2,btOption3,btOption4;
    int inFirstTry ,inSecondTry ,dontSeccede;
    @Override
    protected void onStart() {
        super.onStart();
        inFirstTry =0; inSecondTry=0;dontSeccede=0;
        tvTheGiven = (TextView) findViewById(R.id.tvTheGiven2);
        random = new Random();
        btOption1 =(Button) findViewById(R.id.btOption1);
        btOption2 =(Button) findViewById(R.id.btOption2);
        btOption3 =(Button) findViewById(R.id.btOption3);
        btOption4 =(Button) findViewById(R.id.btOption4);
        roundNum =0;
        periodic = new Periodic[PeriodicTable.getInstance(getApplicationContext()).getNumElements()];
        for (int i = 0; i < periodic.length; i++) {
            periodic[i] = new Periodic(PeriodicTable.getInstance(getApplicationContext()).getPeriodic(i));
        }
        act();
    }

    private void act(){
        if(roundNum == periodic.length){
            Intent intent = new Intent(getApplicationContext() , GamePart2.class);
            intent.putExtra("IN_FIRST_TRY" , inFirstTry);
            intent.putExtra("IN_SECOND_TRY", inSecondTry);
            intent.putExtra("DIDNT_SECCEDE", dontSeccede);
            startActivity(intent);
            return;
        }
        amountofclicks=0;
        tvTheGiven.setText(periodic[roundNum].getName());
        switch (random.nextInt(4)){
            case 0:
                truebutton =1;
                btOption1.setText(periodic[roundNum].getOption1());
                btOption2.setText(periodic[roundNum].getOption2());
                btOption3.setText(periodic[roundNum].getOption3());
                btOption4.setText(periodic[roundNum].getOption4());
                break;
            case 1:
                truebutton =2;
                btOption1.setText(periodic[roundNum].getOption2());
                btOption2.setText(periodic[roundNum].getOption1());
                btOption3.setText(periodic[roundNum].getOption3());
                btOption4.setText(periodic[roundNum].getOption4());
                break;
            case 2:
                truebutton =3;
                btOption1.setText(periodic[roundNum].getOption3());
                btOption2.setText(periodic[roundNum].getOption2());
                btOption3.setText(periodic[roundNum].getOption1());
                btOption4.setText(periodic[roundNum].getOption4());
                break;
            case 3:
                truebutton =4;
                btOption1.setText(periodic[roundNum].getOption4());
                btOption2.setText(periodic[roundNum].getOption2());
                btOption3.setText(periodic[roundNum].getOption3());
                btOption4.setText(periodic[roundNum].getOption1());
                break;

        }

        btOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton == 1){
                    if(amountofclicks == 0){
                        Toast.makeText(Game.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                        roundNum++;
                        act();
                    }else if(amountofclicks ==1){
                        Toast.makeText(Game.this, getText(R.string.correct2),
                                Toast.LENGTH_SHORT).show();
                        inSecondTry++;
                        roundNum++;
                        act();
                    }

                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(Game.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        Toast.makeText(Game.this, getText(R.string.notcorrect)
                                + periodic[roundNum].getOption1() , Toast.LENGTH_SHORT).show();
                        dontSeccede++;
                        roundNum++;
                        act();
                    }
                }
            }
        });
        btOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton == 2){
                    if(amountofclicks == 0){
                        Toast.makeText(Game.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                        roundNum++;
                        act();
                    }else if(amountofclicks ==1){
                        Toast.makeText(Game.this, getText(R.string.correct2),
                                Toast.LENGTH_SHORT).show();
                        inSecondTry++;
                        roundNum++;
                        act();
                    }

                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(Game.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        Toast.makeText(Game.this, getText(R.string.notcorrect)
                                + periodic[roundNum].getOption1() , Toast.LENGTH_SHORT).show();
                        dontSeccede++;
                        roundNum++;
                        act();
                    }
                }
            }
        });
        btOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton == 3){
                    if(amountofclicks == 0){
                        Toast.makeText(Game.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                        roundNum++;
                        act();
                    }else if(amountofclicks ==1){
                        Toast.makeText(Game.this, getText(R.string.correct2),
                                Toast.LENGTH_SHORT).show();
                        inSecondTry++;
                        roundNum++;
                        act();
                    }

                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(Game.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        Toast.makeText(Game.this, getText(R.string.notcorrect)
                                + periodic[roundNum].getOption1() , Toast.LENGTH_SHORT).show();
                        dontSeccede++;
                        roundNum++;
                        act();
                    }
                }
            }
        });
        btOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(truebutton == 4){
                    if(amountofclicks == 0){
                        Toast.makeText(Game.this, getText(R.string.correct1),
                                Toast.LENGTH_SHORT).show();
                        inFirstTry++;
                        roundNum++;
                        act();
                    }else if(amountofclicks ==1){
                        Toast.makeText(Game.this, getText(R.string.correct2),
                                Toast.LENGTH_SHORT).show();
                        inSecondTry++;
                        roundNum++;
                        act();
                    }

                }else{
                    if(amountofclicks==0) {
                        Toast.makeText(Game.this, getText(R.string.notcorrect1), Toast.LENGTH_SHORT).show();
                        amountofclicks =1;
                    }else if(amountofclicks==1){
                        Toast.makeText(Game.this, getText(R.string.notcorrect)
                                + periodic[roundNum].getOption1() , Toast.LENGTH_SHORT).show();
                        dontSeccede++;
                        roundNum++;
                        act();
                    }
                }
            }
        });

    }
}
