package model;

import java.util.Date;

public class Person {
    private String nationalId;
    private String firstName;
    private String lastName;
    private Date bDay;
    private int id;

    public Person(String nationalId, String firstName, String lastName, Date bDay) {
        this.nationalId = nationalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bDay = bDay;

    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }
}
