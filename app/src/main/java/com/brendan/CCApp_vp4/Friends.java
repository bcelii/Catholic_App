package com.brendan.CCApp_vp4;

/**
 * Created by Brendan on 1/7/2016.
 */
public class Friends {
    //attributes

    public String getFriendName() {
        return friendName;
    }

    public YourEvents[] getEventsList() {
        return eventsList;
    }

    private String friendName;
    private YourEvents[] eventsList;

    public Friends(String friendName,YourEvents[] eventList){
        this.friendName = friendName;
        this.eventsList = eventList;
    }

    //Create an array of Friends
    private static YourEvents[] listOfEvents = {new YourEvents("Bob Smith", "1st", "999-999-9999", "Back to School Barbeque",
            "7:00pm", "1/17", "FlagPole", false, "Not Coming"),
            new YourEvents("Joe Jackson", "2nd", "999-999-9999", "Night Mass",
                    "8:00pm", "1/17", "FlagPole", true, "Not Coming"),
            new YourEvents("Billy Yally", "3nd", "999-999-9999", "Morning Mass",
                    "9:00am", "1/17", "FlagPole", true, "Maybe")
    };
    public static final Friends[] friendsList = {
            new Friends("Collette Marshmellow", listOfEvents),
            new Friends("Elise Lebiga", listOfEvents),
            new Friends("Olivia Nguyen",listOfEvents)
    };

    public static final String[] totalSLC = {
            "Celii, Brendan",
            "Marchesseault, Collette",
            "Thrailkill, Chris",
            "Dominguez, Nayelly",
            "Lebiga, Elise",
            "Montan, Kaitlyn",
            "Rosa, Marisa",
            "De Labra, Jose",
            "McCarty, Camille",
            "Garcia, Allison",
            "Sanchez, Adam",
            "Reeve, Samantha",
            "O'Donnell, Brian",
            "Nguyen, Emily",
            "Coughlin, Molly",
            "Walsh, Erin",
            "Slaughter, Robbie",
            "Harkey, Meagan",
            "Owen, Emily Anne",
            "Jendrusch, Sara",
            "Appedu, Gaby",
            "Troxell, Michael"
    };

    public static final String[] friendRequests = {
            "Celii, Buddy",
            "Celii, Francis",
            "Celii, Kieran"
    };



    public static final String[] commonFriendsList = {
            "Common_Person_1",
            "Common_Person_2",
            "Common_Person_3",
            "Common_Person_4",
            "Common_Person_5",
            "Common_Person_6",
            "Common_Person_7",
            "Common_Person_8",
            "Common_Person_9",
            "Common_Person_10",
            "Common_Person_11",
            "Common_Person_12",
            "Common_Person_13",
            "Common_Person_14",
            "Common_Person_15",
            "Common_Person_16",
            "Common_Person_17",
            "Common_Person_18",
            "Common_Person_19",
            "Common_Person_20",
            "Common_Person_21",
            "Common_Person_22",
            "Common_Person_23",
            "Common_Person_24",

    };
    public static final String[] masterListFriends = {
            "Person_1",
            "Person_2",
            "Person_3",
            "Person_4",
            "Person_5",
            "Person_6",
            "Person_7",
            "Person_8",
            "Person_9",
            "Person_10",
            "Person_11",
            "Person_12",
            "Person_13",
            "Person_14",
            "Person_15",
            "Person_16",
            "Person_17",
            "Person_18",
            "Person_19",
            "Person_20",
            "Person_21",
            "Person_22",
            "Person_23",
            "Person_24",

    };


    public String toString() {
        return this.friendName;
    }


}
