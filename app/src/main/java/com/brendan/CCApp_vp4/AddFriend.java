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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AddFriend extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Nav);
        setContentView(R.layout.activity_add_friend);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add New Friend");
        initializeListView();
    }

    private void initializeListView(){
        String[] newFriends = Friends.totalSLC;
        int arrLength = newFriends.length;

        ListView lv = (ListView) findViewById(R.id.new_friend_listView);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                newFriends );

        lv.setAdapter(arrayAdapter);

        final String genericDialogString = "Add New Friend:\n";


        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {


                        String passedName = (String) ((TextView) v).getText();

                        // Create custom dialog object
                        final Dialog dialog = new Dialog(AddFriend.this);
                        // Include dialog.xml file
                        dialog.setContentView(R.layout.dialog_confirm);
                        // Set dialog title
                        //dialog.setTitle("Contact");

                        //set the text String:

                        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                        lp.copyFrom(dialog.getWindow().getAttributes());
                        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                        //lp.height = WindowManager.LayoutParams.MATCH_PARENT;

                        dialog.show();
                        dialog.getWindow().setAttributes(lp);
                        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


                        // set values for custom dialog components - text, image and button
                        TextView text = (TextView) dialog.findViewById(R.id.dialog_confirm_textDialog);
                        String contactString = genericDialogString + passedName;
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
                };
        //Add the listener to the list view

        lv.setOnItemClickListener(itemClickListener);
    }

    public void addContactButtonListener( Button passedContact, final String passedName){

        Button buttonClick = passedContact;

        // add listener to button
        buttonClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(AddFriend.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog);
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
                TextView text = (TextView) dialog.findViewById(R.id.textDialog);
                String contactString = "CONTACT:\n" + passedName;
                text.setText(contactString);
                /*ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
                image.setImageResource(R.drawable.cc_logo_transparent);*/

                dialog.show();

                TextView declineButton = (TextView) dialog.findViewById(R.id.declineButton);
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

        if (id == R.id.quick_home){
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        else if (id == android.R.id.home){
            intent = new Intent(this,MainActivity.class);
            int Page = 2;
            intent.putExtra(MainActivity.REQUEST_FRAG, (int) Page);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
