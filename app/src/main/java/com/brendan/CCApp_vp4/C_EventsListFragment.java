package com.brendan.CCApp_vp4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ListView;

public class C_EventsListFragment extends ListFragment
{


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Intent intent = new Intent(getActivity(), CDayDetails.class);
        intent.setType("text/plain");
        intent.putExtra("day",position);
        startActivity(intent);

        // CustomToast(getActivity(), numbers_digits[(int) id]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] daysOfWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                daysOfWeek);
        setListAdapter(adapter);

        //Code to add a theme
        // create ContextThemeWrapper from the original Activity Context with the custom theme
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_Nav);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        return super.onCreateView(localInflater, container, savedInstanceState);
    }
}


/*
public class C_EventsListFragment extends ListFragment {
    static interface C_EventListListener {
        void itemClicked(long id);
    };

    private C_EventListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        } */

/*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (C_EventListListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }

        //go to CDayDetail activity
        //go to main page of the app

        Intent intent = new Intent(getActivity(), CDayDetails.class);
        intent.setType("text/plain");
        intent.putExtra("day",position);
        startActivity(intent);
    }
}*/

