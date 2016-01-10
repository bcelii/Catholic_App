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
import android.widget.TextView;


public class SpecificPersonInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Nav);
        setContentView(R.layout.activity_specific_person_info);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Person Info");

        initializeInfoSheet();

        int nameID = R.id.specific_person_info_name;


        TextView nameText = (TextView) findViewById(nameID);


        Button cfButton = (Button) findViewById(R.id.specific_person_info_but_common_friends);
        Button contactButton = (Button) findViewById(R.id.specific_person_info_but_contact);
        addCFListener(cfButton);
        addContactButtonListener(contactButton, (String) nameText.getText());
    }



    public void addCFListener(Button cfButton){
        cfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Common_Friends.class);
                startActivity(intent);
            }
        });
    }

    public void addContactButtonListener( Button passedContact, final String passedName){

        Button buttonClick = passedContact;

        // add listener to button
        buttonClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(SpecificPersonInfo.this);
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


    public void initializeInfoSheet(){
        Person myPerson = Person.examplePerson;

        int nameID = R.id.specific_person_info_name;
        int yearID = R.id.specific_person_info_year;
        int phoneID = R.id.specific_person_info_phone;
        int emailID = R.id.specific_person_info_email;

        TextView nameText = (TextView) findViewById(nameID);
        nameText.setText(myPerson.getName());
        TextView yearText = (TextView) findViewById(yearID);
        yearText.setText(myPerson.getYear());
        TextView phoneText = (TextView) findViewById(phoneID);
        phoneText.setText(myPerson.getPhone());
        TextView emailText = (TextView) findViewById(emailID);
        emailText.setText(myPerson.getEmail());

        Button deletePerson = (Button) findViewById(R.id.btn_delete_person);
        addDeletePersonButtonListener(deletePerson, myPerson.getName());




    }

    public void addDeletePersonButtonListener(Button removeButton, final String personName){

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(SpecificPersonInfo.this);
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
                String contactString = "Remove Person:\n" + personName;
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
