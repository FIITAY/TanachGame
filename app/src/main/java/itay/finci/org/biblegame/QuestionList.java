package itay.finci.org.biblegame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import itay.finci.org.biblegame.dragablelist.DynamicListView;
import itay.finci.org.biblegame.dragablelist.StableArrayAdapter;

public class QuestionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periotic_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DynamicListView listView = (DynamicListView) findViewById(R.id.listview);
        ArrayList<String> periotictable = new ArrayList<>();
        for (int i = 0; i < PeriodicTable.getInstance(getApplicationContext()).getNumElements(); i++) {
            periotictable.add(PeriodicTable.getInstance(getApplicationContext()).getPeriodic(i).getName()
                    + " = " + PeriodicTable.getInstance(getApplicationContext()).getPeriodic(i).getOption1());
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_list_item_1, android.R.id.text1, periotictable);
        //listView.setAdapter(adapter);

        StableArrayAdapter adapter = new StableArrayAdapter(this, R.layout.text_view, periotictable);
        //DynamicListView listView = (DynamicListView) findViewById(R.id.listview);

        listView.setCheeseList(periotictable);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

}
