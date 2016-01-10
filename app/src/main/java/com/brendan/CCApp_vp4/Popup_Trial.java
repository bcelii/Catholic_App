package com.brendan.CCApp_vp4;


import android.graphics.Color;
import android.view.WindowManager;
import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.app.Activity;
        import android.app.Dialog;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;


public class Popup_Trial extends Activity{

    private Button buttonClick;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup__trial);

        buttonClick = (Button) findViewById(R.id.buttonClick);

        // add listener to button
        buttonClick.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                final Dialog dialog = new Dialog(Popup_Trial.this);
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
                //TextView text = (TextView) dialog.findViewById(R.id.textDialog);
                //text.setText("This is an even longer text IDK why its not stretching");
                /*ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
                image.setImageResource(R.drawable.cc_logo_transparent);*/

                dialog.show();

                Button declineButton = (Button) dialog.findViewById(R.id.dialog_confirm_cancel);
                // if decline button is clicked, close the custom dialog
                declineButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });


            }

        });

    }

}
