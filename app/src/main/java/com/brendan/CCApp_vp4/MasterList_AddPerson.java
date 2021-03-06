package com.brendan.CCApp_vp4;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MasterList_AddPerson extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Nav);
        setContentView(R.layout.activity_master_list__add_person);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Person");
        setSpinners();
    }

    private void setSpinners(){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            intent = new Intent(this,Settings.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.quick_home){
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        else if (id == android.R.id.home){
            intent = new Intent(this,MainActivity.class);
            int Page = 4;
            intent.putExtra(MainActivity.REQUEST_FRAG, (int) Page);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
