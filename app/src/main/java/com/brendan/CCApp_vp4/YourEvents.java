package com.brendan.CCApp_vp4;

/**
 * Created by Brendan on 1/7/2016.
 */
public class YourEvents {

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getPhone() {
        return phone;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Boolean getInvited() {
        return invited;
    }

    public String getStatus() {
        return status;
    }

    String name;
    String year;
    String phone;
    String eventName;
    String eventTime;
    String eventDate;
    String eventLocation;
    Boolean invited;
    String status;

    public YourEvents(String name, String year, String phone, String eventName,
                      String eventTime, String eventDate, String eventLocation, Boolean invited, String status){
        this.name = name;
        this.year = year;
        this.phone = phone;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.invited = invited;
        this.status = status;

    }




    //attributes:
    public static final YourEvents[] yourEventArray = {
            new YourEvents("Bob Smith", "1st", "999-999-9999", "Back to School Barbeque",
                    "7:00pm","1/17","FlagPole",false,"Not Coming"),
            new YourEvents("Joe Jackson", "2nd", "999-999-9999", "Night Mass",
                    "8:00pm","1/17","FlagPole",true,"Not Coming"),
            new YourEvents("Billy Yally", "3nd", "999-999-9999", "Morning Mass",
                    "9:00am","1/17","FlagPole",true,"Maybe")

    };

}
