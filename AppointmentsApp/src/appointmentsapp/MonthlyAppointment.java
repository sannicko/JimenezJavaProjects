/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsapp;

/**
 *
 * @author Cristy
 */
public class MonthlyAppointment extends Appointment {

    int day;

    //Constructor method for MonthlyAppointment
    public MonthlyAppointment(String description, String person, int day, int hours, int minutes) {
        this.day = day;
        super.setDescription(description);
        super.setLastName(person);
        super.setHour(hours);
        super.setMinutes(minutes);
    }

    //Overriding constructor method for MonthlyAppointment to accomodate test in JUnitTester
    public MonthlyAppointment(int day, String description) {
        this.day = day;
        super.setDescription(description);
    }

    //Checking if there is an appointment on a particular day of the month(any month)
    @Override
    public boolean occursOn(int year, int day, int month) {
        //If there is an appointment, return true, else false
        return this.day == day;
    }

    //Getter method for local class vairable day
    public int getDay() {
        return this.day;
    }

    @Override
    public String toString() {
        return super.toString()
                + Integer.toString(day);
    }

}
