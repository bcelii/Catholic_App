package com.brendan.CCApp_vp4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FriendTop3 extends Activity {
    public static final String EXTRA_FRIENDNO = "friendNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Nav);
        setContentView(R.layout.activity_friend_top3);
        int friendNo = (Integer)getIntent().getExtras().get(EXTRA_FRIENDNO);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Friend Progress");
        generateLayout(friendNo);

        Button removeButton = (Button) findViewById(R.id.friend_event_remove_friend);
        addRemoveEventButtonListener(removeButton, friendNo);

    }

    public void addRemoveEventButtonListener(Button removeButton, int friendNo){
        //get the friend object
        Friends[] friendList = Friends.friendsList;
        Friends friend = friendList[friendNo];

        //set the title of the page
        TextView title = (TextView) findViewById(R.id.friend_top_3_title);
        final String friendName = friend.getFriendName();

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(FriendTop3.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_confirm);
                // Set dialog title
                //dialog.setTitle("Contact");

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                //lp.height = WindowManager.LayoutParams.MATCH_PARENT;

                dialog.show();
                dialog.getWindow().setAttributes(lp);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


                // set values for custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.dialog_confirm_textDialog);
                String contactString = "Remove Friend:\n" + friendName;
                text.setText(contactString);
                /*ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
                image.setImageResource(R.drawable.cc_logo_transparent);*/

                dialog.show();

                TextView declineButton = (TextView) dialog.findViewById(R.id.dialog_confirm_cancel);
                // if decline button is clicked, close the custom dialog
                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });


            }
        });
    }

    private void generateLayout(int friendNo){
        //get the friend object
        Friends[] friendList = Friends.friendsList;
        Friends friend = friendList[friendNo];

        //set the title of the page
        TextView title = (TextView) findViewById(R.id.friend_top_3_title);
        String friendName = friend.getFriendName();
        title.setText(friendName);

        //get the event list
        YourEvents[] myEvents = friend.getEventsList();

        String baseName = "friend_event_";
        //get the number of events
        int lengthArray = myEvents.length;

        String eventName;
        String name;
        String status;
        String date;
        String time;
        Boolean invited;

        for(int i = 1;i<lengthArray+1;i++){
            String LayoutID = baseName + Integer.toString(i);
            Log.v("Debug IDs", LayoutID);
            int resID = getResources().getIdentifier(LayoutID,"id","com.brendan.CCApp_vp4");
            RelativeLayout eventLayout = (RelativeLayout) findViewById(resID);
            YourEvents currentEvent = myEvents[i-1];

            eventName = currentEvent.getEventName();
            name = currentEvent.getName();
            date = currentEvent.getEventDate();
            time = currentEvent.getEventTime();
            invited = currentEvent.getInvited();
            status = currentEvent.getStatus();

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
            titleView.setText(eventName);

            //set the person name
            String withID = LayoutID + "_with";
            Log.v("Debug IDs", withID);
            resID = getResources().getIdentifier(withID,"id","com.brendan.CCApp_vp4");
            TextView nameView = (TextView) findViewById(resID);
            String withString = "WITH: " + name;
            nameView.setText(withString);

            //Set the date
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

            //set invited
            String invitedID = LayoutID + "_invited";
            Log.v("Debug IDs", invitedID);
            resID = getResources().getIdentifier(invitedID,"id","com.brendan.CCApp_vp4");
            CheckBox invitedView = (CheckBox) findViewById(resID);
            invitedView.setChecked(invited);

            //set Status
            String statusID = LayoutID + "_status";
            Log.v("Debug IDs", statusID);
            resID = getResources().getIdentifier(statusID,"id","com.brendan.CCApp_vp4");
            TextView statusView = (TextView) findViewById(resID);
            String statusString = "STATUS: " + status;
            statusView.setText(statusString);

            //set the event to visible
            eventLayout.setVisibility(View.VISIBLE);


        }







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
        if (id == android.R.id.home){
            intent = new Intent(this,MainActivity.class);
            int friendPage = 2;
            intent.putExtra(MainActivity.REQUEST_FRAG, (int) friendPage);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }
}
