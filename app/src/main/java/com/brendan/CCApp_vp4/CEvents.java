package com.brendan.CCApp_vp4;

/**
 * Created by Brendan on 1/7/2016.
 */
public class CEvents {

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getContact() {
        return contact;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    //private attributes private
    String title;
    String time;
    String date;
    String description;
    String location;
    String contact;
    String contactNumber;
    String contactEmail;


    //constructor for class
    private CEvents(String title, String time, String date, String description, String location,
                    String contact, String contactNumber, String contactEmail) {
        this.title = title;
        this.time = time;
        this.date = date;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;

    }


    public static final CEvents[] cEventsArray = {
            new CEvents("Event1", "5 am", "1/6", "Description of Event 1", "Catholic Center",
                    "Brendan Celii", "972-439-7267", "bcelii@smu.edu"),
            new CEvents("Event2", "7 am", "1/6", "Description of Event 2", "Catholic Center",
                    "Brendan Celii", "972-439-7267", "bcelii@smu.edu"),
            new CEvents("Event3", "10 am", "1/6", "Description of Event 3", "Catholic Center",
                    "Brendan Celii", "972-439-7267", "bcelii@smu.edu")
    };

    public static final String[] CEventsList = {
            "Morning Mass",
            "5 PM Mass",
            "8 PM Mass",
            "FYSH",
            "Bible Study",
            "COR",
            "The Bean",
            "Boulevard"
    };
}