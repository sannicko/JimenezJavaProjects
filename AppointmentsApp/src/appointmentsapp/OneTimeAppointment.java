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
public class OneTimeAppointment extends Appointment {

    private int year;
    private int month;
    private int day;

    //Check if there is a oneTime appointment in a particular date (day, month, year)
    @Override
    public boolean occursOn(int year, int day, int month) {
        if (this.year == year && this.day == day && this.month == month) {
            return true;
        } else {
            return false;
        }
    }

    //Constructor method for OneTimeAppointment - int year, int day, int month, String description, String person
    public OneTimeAppointment(int year, int day, int month, int hours, int minutes, String description, String person) {
        this.year = year;
        this.month = month;
        this.day = day;
        super.setHour(hours);
        super.setMinutes(minutes);
        super.setDescription(description);
        super.setLastName(person);
    }

    //Overriding the Constructor method for OneTimeAppointment to accomodate arguments from JUnitTestTester - int year, int day, int month, String description
    public OneTimeAppointment(int year, int day, int month, String description) {
        this.year = year;
        this.month = month;
        this.day = day;
        super.setDescription(description);
    }

    //Getter method for day
    public int getDay() {
        return this.day;
    }

    //Getter method for month
    public int getMonth() {
        return this.month;
    }

    //Getter method for year
    public int getYear() {
        return this.year;
    }

    //toString method
    public String toString() {
        return super.toString()
                + Integer.toString(year)
                + Integer.toString(month)
                + Integer.toString(day);
    }

}