package com.me.ntu.fitness;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class chestsetExplaination extends ActionBarActivity {

    private Spinner levelspinner;
    private Spinner numberspinner;

    private String[] level = {"10kg" , "15kg" , "20kg" , "25kg" };
    private String[] number = {"10下" , "15下" , "20下" , "25下" };

    private ArrayAdapter<String> levellist;
    private ArrayAdapter<String> numberlist;

    public int levelselected = 10;
    public int numberselected = 10;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestset_explaination);

        levelspinner = (Spinner)findViewById(R.id.levelSpinner);
        numberspinner = (Spinner)findViewById(R.id.numberSpinner);
        mContext = this.getApplicationContext();

        levellist = new ArrayAdapter<String>(chestsetExplaination.this , android.R.layout.simple_spinner_item , level);
        numberlist = new ArrayAdapter<String>(chestsetExplaination.this , android.R.layout.simple_spinner_item , number);

        levelspinner.setAdapter(levellist);
        numberspinner.setAdapter(numberlist);


        levelspinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                Toast.makeText(mContext, "你選的是" + level[pos], Toast.LENGTH_SHORT).show();
                levelselected = pos*5 + 10;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        numberspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent , View view , int pos , long id) {

                Toast.makeText(mContext, "你選的是" + number[pos], Toast.LENGTH_SHORT).show();
                numberselected = pos*5 + 10;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void gotraining(View view) {
        Intent intent = new Intent(this , training.class);
        Bundle bundle = new Bundle();
        bundle.putInt("level" , levelselected);
        bundle.putDouble("number" , (double)numberselected );

        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chestset_explaination, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
