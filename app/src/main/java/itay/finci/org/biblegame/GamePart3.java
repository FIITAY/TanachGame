package itay.finci.org.biblegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import itay.finci.org.biblegame.helper.SimpleItemTouchHelperCallback;

public class GamePart3 extends AppCompatActivity {

    int firstTry, secondTry, dontSeccede;
    DinamicListQuestions[] dlqt;
    Button btCheck;
    RecyclerView recyclerView;
    int amountofclicks,roundNum;
    private ItemTouchHelper mItemTouchHelper;


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

        dlqt = new DinamicListQuestions[DinamicListQuestionsList.getInstance(getApplicationContext()).getNumElements()];
        for (int i = 0; i < dlqt.length; i++) {
            dlqt[i] = new DinamicListQuestions(DinamicListQuestionsList.getInstance(getApplicationContext()).getElement(i));
        }

        amountofclicks=0; roundNum=0;
        btCheck =(Button) findViewById(R.id.btSent);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        act();
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
        ArrayList<String>mCheeseList = new ArrayList<String>();
        mCheeseList.add(dlqt[roundNum].getFirst());
        mCheeseList.add(dlqt[roundNum].getSecond());
        mCheeseList.add(dlqt[roundNum].getThird());
        mCheeseList.add(dlqt[roundNum].getForth());
        mCheeseList.add(dlqt[roundNum].getFith());
        System.out.println(mCheeseList);
        Collections.shuffle(mCheeseList);
        RecyclerListAdapter adapter = new RecyclerListAdapter(mCheeseList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);


        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundNum++;
                act();
            }
        });
    }
}
