/**
 *
 * Title:           Appointment App
 * Semester:        COP3804 – Fall 2016
 *
 * @author 5867108 Instructor: C. Charters
 *
 * Due Date: 09/25/2018
 *
 * Description of program, & explanation of programming concept(s) being applied
 * in program This program will create an appointment program to add, search,
 * and display appointments by daily, one time, or month appointments.
 */
package appointmentsapp;

import java.util.Scanner;

/**
 *
 * @author Cristy
 */
public class AppointmentsApp {

    public static Appointment[] myAppointments;

    /**
     * @param args the command line arguments
     */
    /**
     * Note about the input technique used I was using input.nextInt() to get
     * integers but had to change to Integer.parseInt(reader.nextLine because
     * the nextInt() method leaves the return character which causes problems
     * when trying to get a value using nextLine() again
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        int option;

        System.out.println("How many appointments do you wish to make?");
        num = Integer.parseInt(input.nextLine());
        myAppointments = new Appointment[num];

        for (int x = 0; x < num; x++) {
            System.out.println("Please make a selection:");
            System.out.println("1. One Time Appointment");
            System.out.println("2. Daily Appointment");
            System.out.println("3. Monthly Appointment");
            option = Integer.parseInt(input.nextLine());

            //Adding each appointment to the myAppointments array
            if (option == 1) {
                myAppointments[x] = makeOneTimeAppointment();
            } else if (option == 2) {
                myAppointments[x] = makeDailyAppointment();
            } else if (option == 3) {
                myAppointments[x] = makeMonthlyAppointment();
            } else {
                System.out.println("Invalid selection, please select number 1,2 or 3");
                //Reducing x by one so that the current failed iteration is repeated
                x--;
            }
        }

        boolean lookup = true;
        int numOfAppointments = myAppointments.length;
        boolean anyAppts = false;

        do {
            System.out.println("What is the date you wish to look up in your Appointments' Calendar?");
            int month, day, year;
            System.out.println("Enter the month: ");
            //Initially I was using input.nextInt() to get integers but had to 
            //change because the nextInt() method leaves the return character
            //and it causes problems when trying to get a value using nextLine()
            month = Integer.parseInt(input.nextLine());

            System.out.println("Enter the day: ");
            day = Integer.parseInt(input.nextLine());

            System.out.println("Enter the year: ");
            year = Integer.parseInt(input.nextLine());

            System.out.println(
                    "On " + Integer.toString(month)
                    + "/" + Integer.toString(day)
                    + "/" + Integer.toString(year)
                    + " you have the following appointments:"
            );

            for (int y = 0; y < numOfAppointments; y++) {

                if (myAppointments[y].occursOn(year, day, month)) {
                    System.out.println(
                            myAppointments[y].getDescription()
                            + " with "
                            + myAppointments[y].getLastName()
                            + " at "
                            + String.format("%02d", myAppointments[y].getHour())
                            + ":"
                            + String.format("%02d", myAppointments[y].getMinutes())
                    );
                    anyAppts = true;
                }
            }

            if (anyAppts == false) {
                System.out.println("No appointments on this day");
            }

            System.out.println("Do you wish to look up another date? Press YES or NO ");
            String lookupResponse = input.nextLine();
            if (lookupResponse.equalsIgnoreCase("NO")) {
                System.out.println("Thank  you for using your appointment calendar");
                lookup = false;
            } else if (lookupResponse.equalsIgnoreCase("YES")) {
                lookup = true;
            } else {
                System.out.println("Invalid entry, please try again. Press YES or NO");
            }
        } while (lookup);

        input.close();

    }

    //Initializing OneTimeAppointment object using a constructor
    //2018, 10, 19, "Birthday Celebration"
    private static OneTimeAppointment makeOneTimeAppointment() {
        Scanner input = new Scanner(System.in);
        String description, person;
        int year, month, day, hour, minutes;

        System.out.println("What is the description of your appointment?");
        description = input.nextLine();

        System.out.println("What is your person's name?");
        person = input.nextLine();

        System.out.println("What year is your appointment?(2017-2018)");
        year = Integer.parseInt(input.nextLine());

        System.out.println("What month is your appointment?(1-12)");
        month = Integer.parseInt(input.nextLine());

        System.out.println("What day is your appointment?(1-31)");
        day = Integer.parseInt(input.nextLine());

        System.out.println("What is the hour of your appointment?(00-23)");
        hour = Integer.parseInt(input.nextLine());

        System.out.println("What is the minutes of your appointment (00-59)?");
        minutes = Integer.parseInt(input.nextLine());

        OneTimeAppointment oneTime = new OneTimeAppointment(year, day, month, hour, minutes, description, person);

        //Letting the user know the appointment was successfully added
        System.out.println(
                "Appointment added with "
                + oneTime.getDescription()
                + " " + oneTime.getLastName()
                + " on " + oneTime.getMonth()
                + "/" + oneTime.getDay()
                + "/" + oneTime.getYear()
                + " at " + String.format("%02d", oneTime.getHour())
                + ":" + String.format("%02d", oneTime.getMinutes())
        );

        return oneTime;
    }

    //Initializing DailyAppointment object using a constructor
    private static DailyAppointment makeDailyAppointment() {
        Scanner input = new Scanner(System.in);
        String description, person;
        int hour, minutes;

        System.out.println("What is the description of your appointment?");
        description = input.nextLine();

        System.out.println("What is your person's name?");
        person = input.nextLine();

        System.out.println("What is the hour of your appointment?");
        hour = Integer.parseInt(input.nextLine());

        System.out.println("What is the minutes of your appointment?");
        minutes = Integer.parseInt(input.nextLine());

        DailyAppointment daily = new DailyAppointment(description, person, hour, minutes);

        //Letting the user know the appointment was successfully added
        System.out.println(
                "Appointment added with" + " "
                + daily.getDescription() + " "
                + daily.getLastName()
                + " it is daily at "
                + daily.getHour() + ":"
                + daily.getMinutes()
        );

        return daily;
    }

    //Initializing MonthlyAppointment object using getter methods
    private static MonthlyAppointment makeMonthlyAppointment() {
        Scanner input = new Scanner(System.in);

        //Calling the setDescription setter method found in MonthlyAppointment
        System.out.println("What is the description of your appointment?");
        String description = input.nextLine();

        //Calling the setLastName setter method found in MonthlyAppointment
        System.out.println("What is your person's name?");
        String name = input.nextLine();

        System.out.println("What day of the month is your appointment?(1-31)");
        int day = Integer.parseInt(input.nextLine());

        System.out.println("What is the hour of your appointment?(0-23)");
        int hour = Integer.parseInt(input.nextLine());

        System.out.println("What is the minutes of your appointment?(0-59)");
        int minutes = Integer.parseInt(input.nextLine());

        MonthlyAppointment monthly = new MonthlyAppointment(description, name, day, hour, minutes);

        //Letting the user know the appointment was successfully added
        System.out.println(
                "Appointment added with" + " "
                + monthly.getDescription() + " "
                + monthly.getLastName()
                + " on day "
                + monthly.getDay()
                + " at "
                + monthly.getHour() + ":"
                + monthly.getMinutes()
        );
        return monthly;
    }

}
/**
 * Create a menu loop as follows:
 *
 * How many appointments do you wish to make? 3
 *
 * Please make a selection: 1. One Time Appointment 2. Daily Appointment 3.
 * Monthly Appointment * For Each option, request the appropriate data from the
 * user, and then instantiate the appropriate class/subclass in the Appointment
 * hierarchy For each appointment made, you will add it to an array of
 * appointments that you have created when you found out how many appts.
 *
 * Once the menu LOOP is over, ask the user the following question in a Do-While
 * LOOP: What is the date you wish to look up in your Appointments' Calendar?
 * Enter the month: 03 Enter the day: 15 Enter the year: 2017
 *
 * (Display the result in the following format:)
 *
 * On 3 / 15 / 2017 you have the following appointments: Dentist appointment
 * with Dr. Smith at 13:30 Piano Lessons with Ms. Katie at 17:30 Athletic
 * Training with Ms. Jones at 10:00
 *
 * Do you wish to look up another date? (If they answer NO, exit the program
 * with message) “Thank you for using your appointment calendar.”
 *
 * (If they answer YES, continue to ask for another date to look up). "What is
 * the date you wish to look up in your Appointments' Calendar? " etc.,.
 *
 */
