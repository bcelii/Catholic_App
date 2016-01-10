package com.brendan.CCApp_vp4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FriendRequests extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Nav);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_requests);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Friend Requests");
        createYourFR();
    }



    private void createYourFR(){
        String[] friendRequests = Friends.friendRequests;
        int lengthArray = friendRequests.length;

        String nameBase = "FR_name_";
        String layoutBase = "FR_";


        int resID;

        for(int i = 1;i<lengthArray+1;i++){
            //set the title
            String currentRequest = friendRequests[i-1];

            String nameID = nameBase + Integer.toString(i);
            resID = getResources().getIdentifier(nameID,"id","com.brendan.CCApp_vp4");
            TextView nameView = (TextView) findViewById(resID);
            nameView.setText(currentRequest);

            //make visible
            String layoutID = layoutBase + Integer.toString(i);
            resID = getResources().getIdentifier(layoutID,"id","com.brendan.CCApp_vp4");

            LinearLayout linLayout = (LinearLayout) findViewById(resID);
            linLayout.setVisibility(View.VISIBLE);

            String declineID = "btn_decline_" + Integer.toString(i);
            resID = getResources().getIdentifier(declineID,"id","com.brendan.CCApp_vp4");
            Button declineButton = (Button) findViewById(resID);

            addDeclineButtonListener(declineButton, currentRequest);

        }

    }

    public void addDeclineButtonListener(final Button declineButton, final String requestName){
        //get the friend object


        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(FriendRequests.this);
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
                String contactString = "Decline Friend Request:\n" + requestName;
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
        else if (id == R.id.quick_home){
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else if (id == android.R.id.home){
            intent = new Intent(this,MainActivity.class);
            int friendPage = 2;
            intent.putExtra(MainActivity.REQUEST_FRAG, (int) friendPage);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
