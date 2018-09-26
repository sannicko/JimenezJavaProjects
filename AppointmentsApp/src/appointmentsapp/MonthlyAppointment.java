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
