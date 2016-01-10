package com.brendan.CCApp_vp4;

import android.app.ActionBar;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;


public class CDayDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Nav);
        setContentView(R.layout.activity_cday_details);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("C Events");
        createCatholicEvents();

    }

    void createCatholicEvents(){
        CEvents[] myEvents = CEvents.cEventsArray;
        String baseName = "C_day_detail_event_";
        //get the number of events
        int lengthArray = myEvents.length;

        String title;
        String description;
        String location;
        String date;
        String time;
        String contact;

        for(int i = 1;i<lengthArray+1;i++){
            String LayoutID = baseName + Integer.toString(i);
            Log.v("Debug IDs", LayoutID);
            int resID = getResources().getIdentifier(LayoutID,"id","com.brendan.CCApp_vp4");
            RelativeLayout eventLayout = (RelativeLayout) findViewById(resID);
            CEvents currentEvent = myEvents[i-1];

            title = currentEvent.getTitle();
            description = currentEvent.getDescription();
            location = currentEvent.getLocation();
            date = currentEvent.getDate();
            time = currentEvent.getTime();
            contact = currentEvent.getContact();

            //set the event name
            String titleID = LayoutID + "_title";
            //Log.v("Debug IDs", titleID);
            resID = getResources().getIdentifier(titleID,"id","com.brendan.CCApp_vp4");
            //Log.v("Debug IDs resID:",Integer.toString(resID));
            //int resID2 = R.id.top_frag_event_1_title;
            //Log.v("Debug IDs resID2:",Integer.toString(resID2));
            //int resID3 = R.id.top_frag_event_1_with;
            //Log.v("Debug IDs with:",Integer.toString(resID3));
            TextView titleView = (TextView) findViewById(resID);
            titleView.setText(title);

            //set the person name
            String descriptionID = LayoutID + "_description";
            Log.v("Debug IDs", descriptionID);
            resID = getResources().getIdentifier(descriptionID,"id","com.brendan.CCApp_vp4");
            TextView descriptionView = (TextView) findViewById(resID);

            descriptionView.setText(description);

            //Set the date
            String locationID = LayoutID + "_location";
            Log.v("Debug IDs", locationID);
            resID = getResources().getIdentifier(locationID,"id","com.brendan.CCApp_vp4");
            TextView locationView = (TextView) findViewById(resID);
            locationView.setText(location);

            //set time
            String dateID = LayoutID + "_date";
            Log.v("Debug IDs", dateID);
            resID = getResources().getIdentifier(dateID,"id","com.brendan.CCApp_vp4");
            TextView dateView = (TextView) findViewById(resID);
            dateView.setText(date);

            //set time
            String timeID = LayoutID + "_time";
            Log.v("Debug IDs", timeID);
            resID = getResources().getIdentifier(timeID,"id","com.brendan.CCApp_vp4");
            TextView timeView = (TextView) findViewById(resID);
            timeView.setText(time);

            //set Status
            String contactID = LayoutID + "_contact";
            Log.v("Debug IDs", contactID);
            resID = getResources().getIdentifier(contactID,"id","com.brendan.CCApp_vp4");
            TextView contactView = (TextView) findViewById(resID);
            contactView.setText(contact);

            //set the event to visible
            eventLayout.setVisibility(View.VISIBLE);


        }


    }

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
            int Page = 3;
            intent.putExtra(MainActivity.REQUEST_FRAG, (int) Page);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
