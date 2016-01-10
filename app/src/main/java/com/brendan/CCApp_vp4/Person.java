package com.brendan.CCApp_vp4;

/**
 * Created by Brendan on 1/9/2016.
 */
public class Person {
    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    String name;
    String year;
    String phone;
    String email;

    public Person(String name,String year, String phone, String email){
        this.name = name;
        this.year = year;
        this.phone = phone;
        this.email = email;
    }

    public static final Person examplePerson = new Person("Francis Cell", "4th",
            "972-768-2546","fcelii@swag.com");
}
