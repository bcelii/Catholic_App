package com.brendan.CCApp_vp4;


import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.brendan.CCApp_vp4.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {


    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Code to add a theme
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_Nav);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_top, container, false);
        createYourEvents(view);
        setButtonListeners(view);
        //set the button listeners


        return view;
    }

    private void setButtonListeners(View view){
        Button catholicButton = (Button) view.findViewById(R.id.btn_C_events);
        catholicButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getActivity(),CDayDetails.class);
                startActivity(intent);
            }
        });

        Button FriendProgressButton = (Button) view.findViewById(R.id.btn_top_friend_progress);
        FriendProgressButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getActivity(),MainActivity.class);
                int friendPage = 2;
                intent.putExtra(MainActivity.REQUEST_FRAG, (int) friendPage);
                startActivity(intent);
            }
        });

        Button FriendRequestButton = (Button) view.findViewById(R.id.btn_top_friend_request);
        FriendRequestButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getActivity(),FriendRequests.class);
                startActivity(intent);
            }
        });


    }
    public void goToTop3(View view){
        Intent intent = new Intent (getActivity(),MainActivity.class);
        int top3Page = 1;
        intent.putExtra(MainActivity.REQUEST_FRAG, (int) top3Page);
        startActivity(intent);
    }



    //method that will make visible and fill the containers with all your events
    private void createYourEvents(View view){
        YourEvents[] myEvents = YourEvents.yourEventArray;
        String baseName = "top_frag_event_";
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
            RelativeLayout eventLayout = (RelativeLayout) view.findViewById(resID);
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
            TextView titleView = (TextView) view.findViewById(resID);
            titleView.setText(eventName);

            //set the person name
            String withID = LayoutID + "_with";
            Log.v("Debug IDs", withID);
            resID = getResources().getIdentifier(withID,"id","com.brendan.CCApp_vp4");
            TextView nameView = (TextView) view.findViewById(resID);
            String withString = "WITH: " + name;
            nameView.setText(withString);

            //Set the date
            String dateID = LayoutID + "_date";
            Log.v("Debug IDs", dateID);
            resID = getResources().getIdentifier(dateID,"id","com.brendan.CCApp_vp4");
            TextView dateView = (TextView) view.findViewById(resID);
            dateView.setText(date);

            //set time
            String timeID = LayoutID + "_time";
            Log.v("Debug IDs", timeID);
            resID = getResources().getIdentifier(timeID,"id","com.brendan.CCApp_vp4");
            TextView timeView = (TextView) view.findViewById(resID);
            timeView.setText(time);

            //set invited
            String invitedID = LayoutID + "_invited";
            Log.v("Debug IDs", invitedID);
            resID = getResources().getIdentifier(invitedID,"id","com.brendan.CCApp_vp4");
            CheckBox invitedView = (CheckBox) view.findViewById(resID);
            invitedView.setChecked(invited);

            //set Status
            String statusID = LayoutID + "_status";
            Log.v("Debug IDs", statusID);
            resID = getResources().getIdentifier(statusID,"id","com.brendan.CCApp_vp4");
            TextView statusView = (TextView) view.findViewById(resID);
            String statusString = "STATUS: " + status;
            statusView.setText(statusString);

            //set the event to visible
            eventLayout.setVisibility(View.VISIBLE);

            //set an onClick listener
            eventLayout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent (getActivity(),MainActivity.class);
                    int top3Page = 1;
                    intent.putExtra(MainActivity.REQUEST_FRAG, (int) top3Page);
                    startActivity(intent);
                }
            });


        }



    }


}
