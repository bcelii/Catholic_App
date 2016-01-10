package com.brendan.CCApp_vp4;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {


    public MasterListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_Nav);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_master_list, container, false);
        Log.v("Is view null", Boolean.toString(view == null));
        initializeView(view);
        addButtonListener(view);
        return view;
    }

    private void initializeView(View view){
        //get the array of all of your friends
        String[] masterList = Friends.masterListFriends;
        int arrLength = masterList.length;

        final ListView lv = (ListView) view.findViewById(R.id.new_friend_listView);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                masterList );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String passedName = (String) lv.getItemAtPosition(position);
                //set intent with the name
                Intent intent = new Intent(getActivity(),SpecificPersonInfo.class);
                intent.setType("text/plain");
                intent.putExtra("name",passedName);
                startActivity(intent);

            }
        });

    }

    private void addButtonListener(View view){
        Button catholicButton = (Button) view.findViewById(R.id.btn_add_person);
        catholicButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(),MasterList_AddPerson.class);
                startActivity(intent);
            }
        });
    }


}
