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
public class DailyAppointment extends Appointment{

    @Override
    public boolean occursOn(int year, int day, int month) {
        //A daily appointment occurs everyday so regardless 
        //of the year, month or day, this method will always return true
        return true;
    }
    
    //Constructor method for DailyAppointment
    public DailyAppointment(String description, String person, int hours, int minutes){
        super.setDescription(description);
        super.setLastName(person);
        super.setHour(hours);
        super.setMinutes(minutes);
    }
    
    //Overiding the constructor method to accomodate test in JUnitTester
    public DailyAppointment(String description){
        super.setDescription(description);
    }
    
    public int getDay(){
        return 1;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
}
