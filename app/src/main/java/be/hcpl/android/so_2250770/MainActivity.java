package be.hcpl.android.so_2250770;

import android.app.Activity;
import android.graphics.AvoidXfermode;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class MainActivity extends Activity {

    private MyListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        // create some dummy data here
        List<ModelObject> objects = getRandomData();
        // and put it into an adapter for the list
        mAdapter = new MyListAdapter(this, objects);
        list.setAdapter(mAdapter);

        // mAdapter is available in the helper methods below and the data will be updated based on
        // action menu interactions

        // you could also keep the reference to the android ListView object instead and use the
        // {@link ListView#getAdapter()} method instead. However you would have to cast that
        // adapter to your own instance every time
    }

    /**
     * creates some random model objects
     *
     * @return
     */
    private List<ModelObject> getRandomData(){
        List<ModelObject> objects = new ArrayList<ModelObject>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt();
            objects.add(new ModelObject("object " + randomNumber, Calendar.getInstance(), randomNumber % 2 == 0));
        }
        return objects;
    }

    /**
     * helper to show what happens when all data is new
     */
    private void reloadAllData(){
        // get new modified random data
        List<ModelObject> objects = getRandomData();
        // update data in our adapter
        mAdapter.getData().clear();
        mAdapter.getData().addAll(objects);
        // fire the event
        mAdapter.notifyDataSetChanged();
    }

    /**
     * helper to show how only changing properties of data elements also works
     */
    private void scrambleChecked(){
        Random random = new Random();
        // update data in our adapter, iterate all objects and resetting the checked option
        for( ModelObject mo : mAdapter.getData()) {
            mo.setChecked(random.nextBoolean());
        }
        // fire the event
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_scramble) {
            scrambleChecked();
            return true;
        } else if (id == R.id.action_reload) {
            reloadAllData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
