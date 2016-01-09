package com.brendan.CCApp_vp4;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.brendan.CCApp_vp4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Top3Fragment extends Fragment {


    public Top3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_Nav);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_top3, container, false);
        createYourEvents(view);
        setButtonListeners(view);

        return view;

    }

    private void setButtonListeners(View view){
        Button newEventButton = (Button) view.findViewById(R.id.btn_top3_add_event);
        newEventButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getActivity(),NewEvent.class);
                startActivity(intent);
            }
        });


    }

    //method that will make visible and fill the containers with all your events
    private void createYourEvents(View view) {
        YourEvents[] myEvents = YourEvents.yourEventArray;
        String baseName = "top3_event_";
        //get the number of events
        int lengthArray = myEvents.length;
        String eventName;
        String name;
        String status;
        String date;
        String time;
        Boolean invited;

        for (int i = 1; i < lengthArray + 1; i++) {
            String LayoutID = baseName + Integer.toString(i);
            Log.v("Debug IDs", LayoutID);
            int resID = getResources().getIdentifier(LayoutID, "id", "com.brendan.CCApp_vp4");
            LinearLayout eventLayout = (LinearLayout) view.findViewById(resID);
            YourEvents currentEvent = myEvents[i - 1];

            eventName = currentEvent.getEventName();
            name = currentEvent.getName();
            date = currentEvent.getEventDate();
            time = currentEvent.getEventTime();
            invited = currentEvent.getInvited();
            status = currentEvent.getStatus();

            //set the event name
            String titleID = LayoutID + "_title";
            //Log.v("Debug IDs", titleID);
            resID = getResources().getIdentifier(titleID, "id", "com.brendan.CCApp_vp4");
            //Log.v("Debug IDs resID:",Integer.toString(resID));
            //int resID2 = R.id.top_frag_event_1_title;
            //Log.v("Debug IDs resID2:",Integer.toString(resID2));
            //int resID3 = R.id.top_frag_event_1_with;
            //Log.v("Debug IDs with:",Integer.toString(resID3));
            TextView titleView = (TextView) view.findViewById(resID);
            titleView.setText(eventName);

            //set the person name
            String withID = LayoutID + "_with";
            Log.v("Debug IDs", withID);
            resID = getResources().getIdentifier(withID, "id", "com.brendan.CCApp_vp4");
            TextView nameView = (TextView) view.findViewById(resID);
            String withString = "WITH: " + name;
            nameView.setText(withString);

            //Set the date
            String dateID = LayoutID + "_date";
            Log.v("Debug IDs", dateID);
            resID = getResources().getIdentifier(dateID, "id", "com.brendan.CCApp_vp4");
            TextView dateView = (TextView) view.findViewById(resID);
            dateView.setText(date);

            //set time
            String timeID = LayoutID + "_time";
            Log.v("Debug IDs", timeID);
            resID = getResources().getIdentifier(timeID, "id", "com.brendan.CCApp_vp4");
            TextView timeView = (TextView) view.findViewById(resID);
            timeView.setText(time);

            //set invited
            String invitedID = LayoutID + "_invited";
            Log.v("Debug IDs", invitedID);
            resID = getResources().getIdentifier(invitedID, "id", "com.brendan.CCApp_vp4");
            CheckBox invitedView = (CheckBox) view.findViewById(resID);
            invitedView.setChecked(invited);

            //set Status
            String statusID = LayoutID + "_status_spinner";
            Log.v("Debug IDs", statusID);
            resID = getResources().getIdentifier(statusID, "id", "com.brendan.CCApp_vp4");
            Spinner statusView = (Spinner) view.findViewById(resID);
            setSpinnerValue(status,statusView);

            //String statusString = "STATUS: " + status;
            //statusView.setText(statusString);

            //set the event to visible
            eventLayout.setVisibility(View.VISIBLE);


        }
    }

    private void setSpinnerValue(String status,Spinner statusView){
        int position;

       if(status == "Maybe"){
            position = 1;
        }
        else if(status == "Not Coming"){
            position = 2;
        }
        else if(status == "Coming"){
            position = 3;
        }
        else{
            position = 0;
        }

        statusView.setSelection(position);


    }

}
