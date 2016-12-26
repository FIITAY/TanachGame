package itay.finci.org.biblegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GamePart2 extends AppCompatActivity {

    truefalseTable TruefalseTable;
    int firstTry,secondTry,dontSeccede;
    truefalse[] tft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
         firstTry= b.getInt("IN_FIRST_TRY");
         secondTry =b.getInt("IN_SECOND_TRY");
         dontSeccede = b.getInt("DIDNT_SECCEDE");

        tft= new truefalse[2];
        for (int i = 0; i < tft.length; i++) {
            tft[i] = new truefalse(truefalseTable.getInstance(getApplicationContext()).getTrueFalse(i));
        }

    }
    TextView tvTheGiven;
    Button btTrue, btFalse;
    boolean its;
    int roundNum;

    @Override
    protected void onStart() {
        super.onStart();
        tvTheGiven = (TextView) findViewById(R.id.tvTheGiven2);
        btTrue = (Button) findViewById(R.id.btTrue);
        btFalse = (Button) findViewById(R.id.btFalse);
        roundNum =0;
        act();
       /*
        tf = new truefalse[2];
        for (int i = 0; i < tf.length; i++) {
            tf[i] = new truefalse(truefalseTable.getInstance(getApplicationContext()).getTrueFalse(i));
        }
        */

    }

    private void act(){
        if(roundNum == tft.length){
            Intent intent = new Intent(getApplicationContext() , GamePart3.class);
            intent.putExtra("IN_FIRST_TRY" , firstTry);
            intent.putExtra("IN_SECOND_TRY", secondTry);
            intent.putExtra("DIDNT_SECCEDE", dontSeccede);
            startActivity(intent);
            return;
        }
        tvTheGiven.setText(tft[roundNum].getName());
        its = tft[roundNum].isTf();
        btTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(its == true){
                    Toast.makeText(GamePart2.this, getText(R.string.correct1),
                            Toast.LENGTH_SHORT).show();
                    firstTry++;
                    roundNum++;
                    act();
                }else{
                    Toast.makeText(GamePart2.this, getText(R.string.notcorrect)
                            + "לא נכון" , Toast.LENGTH_SHORT).show();
                    dontSeccede++;
                    roundNum++;
                    act();
                }
            }
        });
        btFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(its == false){
                    Toast.makeText(GamePart2.this, getText(R.string.correct1),
                            Toast.LENGTH_SHORT).show();
                    firstTry++;
                    roundNum++;
                    act();
                }else{
                    Toast.makeText(GamePart2.this, getText(R.string.notcorrect)
                            + "נכון" , Toast.LENGTH_SHORT).show();
                    dontSeccede++;
                    roundNum++;
                    act();
                }
            }
        });
    }
}
