package codes.sample.samplecustomlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView nameAndAgeListView = (ListView) findViewById(R.id.listView);

//create your listView with your custom object
        ArrayList<NameAndAgeClass> nameAndAgeList = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i ++){
            NameAndAgeClass entry = new NameAndAgeClass("Name " + i, i);
            nameAndAgeList.add(entry);
        }

//create your adapter, use the nameAndAgeList ArrayList
        CustomListViewAdapterNameAndAge nameAndAgeAdapter = new CustomListViewAdapterNameAndAge(this, nameAndAgeList);

//get your listView and use your adapter
        nameAndAgeListView.setAdapter(nameAndAgeAdapter);

        nameAndAgeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //Do what ever you want inside this onItemClick function
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
