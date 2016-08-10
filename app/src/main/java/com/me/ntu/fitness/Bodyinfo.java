package com.me.ntu.fitness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Bodyinfo extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyinfo);
    }

    public void confirminfo(View view) {
        EditText bmi = (EditText) findViewById(R.id.editText4);
        EditText ffmi = (EditText) findViewById(R.id.editText5);
        EditText height = (EditText) findViewById(R.id.editText);
        EditText weight = (EditText) findViewById(R.id.editText2);
        EditText fat = (EditText) findViewById(R.id.editText3);
        String h = height.getText().toString();
        String w = weight.getText().toString();
        String f = fat.getText().toString();

        double hei = Double.parseDouble(h);
        double wei = Double.parseDouble(w);
        double fa = Double.parseDouble(f);

        double bmii = wei / (hei*hei) * 10000;
        double ffmii = wei * (1-(fa*0.01)) / (hei*hei) * 10000;

        bmi.setText(String.valueOf(bmii));
        ffmi.setText(String.valueOf(ffmii));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bodyinfo, menu);
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
