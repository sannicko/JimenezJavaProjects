/**

  Title:           Appointment App
  Semester:        COP3804 – Fall 2016
  @author          5867108
   Instructor:     C. Charters
  
   Due Date:      09/25/2018

    Description of program, & explanation of programming concept(s) being  applied in program
    This program will create an appointment program to add, search, and display appointments by
    daily, one time, or month appointments.
 */
package appointmentsapp;

/**
 *
 * @author Cristy
 */
public class DailyAppointment extends Appointment {

    @Override
    public boolean occursOn(int year, int day, int month) {
        //A daily appointment occurs everyday so regardless 
        //of the year, month or day, this method will always return true
        return true;
    }

    //Constructor method for DailyAppointment
    public DailyAppointment(String description, String person, int hours, int minutes) {
        super.setDescription(description);
        super.setLastName(person);
        super.setHour(hours);
        super.setMinutes(minutes);
    }

    //Overiding the constructor method to accomodate test in JUnitTester
    public DailyAppointment(String description) {
        super.setDescription(description);
    }

    public int getDay() {
        return 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
