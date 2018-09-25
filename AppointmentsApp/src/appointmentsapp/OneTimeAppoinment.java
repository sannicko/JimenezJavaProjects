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
public class OneTimeAppointment extends Appointment{
    private int year;
    private int month;
    private int day;
    
    //Check if there is a oneTime appointment in a particular date (day, month, year)
    @Override
    public boolean occursOn(int year, int day, int month) {
        if(this.year == year && this.day == day && this.month == month){
            return true;
        }else{
            return false;
        }
    }
    
    //Constructor method for OneTimeAppointment - int year, int day, int month, String description, String person
    public OneTimeAppointment(int year, int day, int month, int hours, int minutes, String description, String person){
        this.year = year;
        this.month = month;
        this.day = day;
        super.setHour(hours);
        super.setMinutes(minutes);
        super.setDescription(description);
        super.setLastName(person);
    }
    
    //Overriding the Constructor method for OneTimeAppointment to accomodate arguments from JUnitTestTester - int year, int day, int month, String description
    public OneTimeAppointment(int year, int day, int month, String description){
        this.year = year;
        this.month = month;
        this.day = day;
        super.setDescription(description);
    }
        
    
    //Getter method for day
    public int getDay(){
        return this.day;
    }
    
    //Getter method for month
    public int getMonth(){
        return this.month;
    }
    
    //Getter method for year
    public int getYear(){
        return this.year;
    }
    
    //toString method
    public String toString(){
        return super.toString() 
                + Integer.toString(year) 
                + Integer.toString(month) 
                + Integer.toString(day);
    }
    
    
}
