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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.brendan.CCApp_vp4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {


    public FriendsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_Nav);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_friends, container, false);
        initializeListView(view);
        setButtonListeners(view);
        return view;
    }

    private void setButtonListeners(View view) {

        Button FriendProgressButton = (Button) view.findViewById(R.id.btn_add_friends);
        FriendProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddFriend.class);
                startActivity(intent);
            }
        });

        Button FriendRequestButton = (Button) view.findViewById(R.id.btn_view_friend_requests);
        FriendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FriendRequests.class);
                startActivity(intent);
            }
        });
    }

    public void initializeListView(View view){
        Friends[] myFriends = Friends.friendsList;
        int arrLength = myFriends.length;

        ListView lv = (ListView) view.findViewById(R.id.friends_listView);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String>();
        Log.v("arrLength = ", Integer.toString(arrLength));
        for(int i = 0;i<arrLength;i++){
            Friends currentFriend = myFriends[i];
            Log.v("Friend Name = ", currentFriend.getFriendName());
            your_array_list.add(currentFriend.getFriendName());
        }
        Log.v("Alert","Print from List<String>");
        for(int i = 0; i < your_array_list.size(); i++) {
            System.out.println(your_array_list.get(i));
        }


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<Friends> arrayAdapter = new ArrayAdapter<Friends>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                myFriends );

        lv.setAdapter(arrayAdapter);

        //Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {

                        Intent intent = new Intent(getActivity(),
                                FriendTop3.class);
                        intent.putExtra(FriendTop3.EXTRA_FRIENDNO, (int) id);
                        startActivity(intent);

                    }
                };
        //Add the listener to the list view

        lv.setOnItemClickListener(itemClickListener);




    }


}
