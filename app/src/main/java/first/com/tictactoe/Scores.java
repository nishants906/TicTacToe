package first.com.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class Scores extends Activity {

    MyDBHandler handler;
    ListView scoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        scoresList = (ListView) findViewById(R.id.scoresList);
        handler = new MyDBHandler(this, null, null, 1);

        String scores[]=handler.databaseToString();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scores);
        scoresList.setAdapter(adapter);

    }

    public void resetButtonClicked(View v)
    {
        handler.reset();
        String scores[]=handler.databaseToString();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, scores);
        scoresList.setAdapter(adapter);
    }
}
