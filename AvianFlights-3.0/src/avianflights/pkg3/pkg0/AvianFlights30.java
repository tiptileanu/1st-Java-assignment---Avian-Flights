package avianflights.pkg3.pkg0;

import java.util.Scanner;

public class AvianFlights30 {
    
    // scanner is being initialised
    public static Scanner keyboard = new Scanner(System.in);
    
    //3 flights are created of type Flight
    static Flight London_to_Cluj = new Flight("London", "Cluj");
    static Flight Paris_to_London = new Flight("Paris", "London");
    static Flight Rome_to_Madrid = new Flight("Rome", "Madrid");
    
    //variablke that keeps track of profit or loss ie being initialised
    static double pl = -62.5 * 15;
    
    //2 variables are created for text color
    //RED for text colour red, and reset for text colour reset
    public static final String RED = "\u001B[31m";
    public static final String COLOUR_RESET = "\u001B[0m";

    //method that gets customers' details using keyboard input(Scanner)
    public static Customer getInfo() {

        Customer newCustomer;
        keyboard.nextLine();
        System.out.print("Please enter passanger's first name: ");
        String fn = keyboard.nextLine();
        System.out.print("Please enter passanger's surname: ");
        String sn = keyboard.nextLine();
        System.out.print("Please enter passanger's date of birth: ");
        String dob = keyboard.nextLine();
        System.out.print("Please enter passanger's  address: ");
        String add = keyboard.nextLine();
        System.out.print("Please enter passanger's telephone number:");
        String tel = keyboard.nextLine();
        System.out.print("Please enter passanger's email: ");
        String email = keyboard.nextLine();
        System.out.print("Please enter passanger's passport number: ");
        String ppNum = keyboard.nextLine();
        
        //customer's age is checked
        System.out.println("Is the customer under 16 years old Y/N?");
        String answer = keyboard.nextLine();
        
        //if customer is over 16 (not under 16) 
        //new customer of type Custromer is being created
        if (answer.equalsIgnoreCase("n")) {
            newCustomer = new Customer(fn, sn, dob, add, tel, email, ppNum);
            return newCustomer;
        } else {
            //if customer is UNDER 16 new customer of type U16(under 16) is created
            //which means some details from customer's parent are required
            System.out.print("Please enter parent's first name: ");
            String pfn = keyboard.nextLine();
            System.out.print("Please enter parent's surname: ");
            String psn = keyboard.nextLine();
            
            //because the parent does NOT travel, not all details are required
            //but the constructor needs all declared variables
            //empty values are given to variables holding values... 
            //...for details that re not needed
            String pdob = "";
            String padd = "";
            System.out.print("Please enter parent's telephone number:");
            String ptel = keyboard.nextLine();
            System.out.print("Please enter parent's email: ");
            String pemail = keyboard.nextLine();
            String pppNum = "";
            newCustomer = new U16(fn, sn, dob, add, tel, email, ppNum, new Customer(pfn, psn, pdob, padd, ptel, pemail, pppNum));
            return newCustomer;
        }
    }

    //method that calls main menu is created
    public static void MainMenu() {

        System.out.println("*********************************");
        System.out.println("*****     AVIAN FLIGHTS     *****");
        System.out.println("*********************************");
        System.out.println("1. Book flight");
        System.out.println("2. Cancel flight");
        System.out.println("3. View available seats");
        System.out.println("4. View price");
        System.out.println("5. List all flights");
        System.out.println("6. ***Management Reporting***");
        System.out.println("7. \tExit");

        //input protection
        //an option with values between 1-7 is needed so everything else is ignored
        //if a non-numeric value is entered, e red warning message is displayed
        int option;
        do {
            System.out.print("Please select an option: ");
            while (!keyboard.hasNextInt()) {
                System.out.println(RED + "That's not a valid option!" + COLOUR_RESET);
                keyboard.next(); // this is important!
                System.out.print("Please enter a valid option(1-7): ");
            }
            option = keyboard.nextInt();
        } while (option <= 0 || option >=8);

        //for menu's options a switch statement is needed
        switch (option) {

            //option one is for bookings, which then calls the sub-menu
            case 1:
                switch (subMenu()) {
                    case 1:
                        pl += London_to_Cluj.bookTicket(getInfo());
                        break;

                    case 2:
                        pl += Paris_to_London.bookTicket(getInfo());
                        break;

                    case 3:
                        pl += Rome_to_Madrid.bookTicket(getInfo());
                        break;

                    case 4:
                        MainMenu();
                        break;

                    case 5:
                        System.exit(0);

                    //allowed options are 1-5(for sub-menu);
                    //sub-menu is needed to chose the flight's route
                    //any other values are ignored and red message is displayed
                    default:
                        System.out.print(RED + "Please enter a valid option(1-5): \n");
                }
                break;

            //case 2 of main menu calls booking cancellation method
            //which then calls the sub menu, to chode the flight's route
            case 2:
                switch (subMenu()) {
                    case 1:
                        keyboard.nextLine();
                        System.out.print("Please enter customer's passport number: ");
                        String passportNumber = keyboard.nextLine();
                        pl -= London_to_Cluj.cancelBooking(passportNumber);
                        break;

                    case 2:
                        keyboard.nextLine();
                        System.out.print("Please enter customer's passport number: ");
                        passportNumber = keyboard.nextLine();
                        pl -= Paris_to_London.cancelBooking(passportNumber);
                        break;

                    case 3:
                        keyboard.nextLine();
                        System.out.print("Please enter customer's passport number: ");
                        passportNumber = keyboard.nextLine();
                        pl -= Rome_to_Madrid.cancelBooking(passportNumber);
                        break;
                        
                    //case 4 goes back to main menu
                    case 4:
                        MainMenu();
                        break;

                    //case 5 exits the programm
                    case 5:
                        System.exit(0);

                    //any other option value is ignored and red massage displayed
                    default:
                        System.out.print(RED + "Please enter a valid option(1-5): \n");
                }
                break;

            //case(option) 3 checks for available seats per flight
            //again sub-menu is needed to choose the flght's route
            case 3:
                switch (subMenu()) {
                    case 1:
                        
                        //variable that help with available seats output consistency
                        
                        //seats availability for London to Cluj flight
                        String availableTicketsFormat = "| %-50s |%n";
                        System.out.format("+----------------------------------------------------+\n");
                        System.out.format(availableTicketsFormat, "   " + London_to_Cluj.getAvailableSeats() + " seats available on London to Cluj flight.");
                        System.out.format("+----------------------------------------------------+\n");
                        break;

                    case 2:
                        //seats availability for Paris to London flight
                        availableTicketsFormat = "| %-50s |%n";
                        System.out.format("+----------------------------------------------------+\n");
                        System.out.format(availableTicketsFormat, "   " + Paris_to_London.getAvailableSeats() + " seats available on Paris to London flight.");
                        System.out.format("+----------------------------------------------------+\n");
                        break;

                    case 3:
                        //seats availability for Rome to Madrid flight
                        availableTicketsFormat = "| %-50s |%n";
                        System.out.format("+----------------------------------------------------+\n");
                        System.out.format(availableTicketsFormat, "   " + Rome_to_Madrid.getAvailableSeats() + " seats available on Rome to Madrid flight.");
                        System.out.format("+----------------------------------------------------+\n");
                        break;

                    case 4:
                        //option 4 "back", goes back to main menu
                        MainMenu();
                        break;

                    //option 5 exits the programm
                    case 5:
                        System.exit(0);

                    default:
                        //anything else displays a red message to chose a velid option 1-5
                        System.out.println(RED + "Please enter a valid option(1-5): \n");
                }

                break;

            case 4:
                
                //case 4 checks the price of next ticket on chosen route
                //sub-menu is called to choose the flight's route
                switch (subMenu()) {
                    case 1:
                        //price of next ticket for London to Cluj flight
                        String nextTicketFormat = "| %-56s |%n";
                        System.out.format("+----------------------------------------------------------+\n");
                        System.out.format(nextTicketFormat, "Price for next ticket on route London to Cluj: " + London_to_Cluj.getPrice());
                        System.out.format("+----------------------------------------------------------+\n");
                        break;

                    case 2:
                        //price of next ticket for Paris to London flight
                        nextTicketFormat = "| %-56s |%n";
                        System.out.format("+----------------------------------------------------------+\n");
                        System.out.format(nextTicketFormat, "Price for next ticket on route Paris to London: " + Paris_to_London.getPrice());
                        System.out.format("+----------------------------------------------------------+\n");
                        break;

                    case 3:
                        //price of next ticket for Rome to Madrid flight
                        nextTicketFormat = "| %-56s |%n";
                        System.out.format("+----------------------------------------------------------+\n");
                        System.out.format(nextTicketFormat, "Price for next ticket on route Rome to Madrid: " + Rome_to_Madrid.getPrice());
                        System.out.format("+----------------------------------------------------------+\n");
                        break;

                    case 4:
                        //back to main menu
                        MainMenu();
                        break;

                    case 5:
                        //exit programm
                        System.exit(0);

                    default:
                        //red warning message to chose a valid option
                        System.out.println(RED + "Please enter a valid option(1-5): \n");
                }
                break;

            case 5:
                //lists situation on all flights: seats available and price per ticket per flight
               String listAllFlightsFormat = "| %-77s |%n";
               System.out.format("+-------------------------------------------------------------------------------+\n");
               System.out.format(listAllFlightsFormat, "   " + London_to_Cluj.getAvailableSeats() + " seats available on London to Cluj flight, at starting price of: " + London_to_Cluj.getPrice());
               System.out.format("+-------------------------------------------------------------------------------+\n");            
               System.out.format(listAllFlightsFormat, "   " + Paris_to_London.getAvailableSeats() + " seats available on Paris to London flight, at starting price of: " + Paris_to_London.getPrice());
               System.out.format("+-------------------------------------------------------------------------------+\n");
               System.out.format(listAllFlightsFormat, "   " + Rome_to_Madrid.getAvailableSeats() + " seats available on Rome to Madrid flight, at starting price of: " + Paris_to_London.getPrice());
               System.out.format("+-------------------------------------------------------------------------------+\n");
               break;

            case 6:
                //amount of sold tickets so far is calclated
                int soldTickets = 15 - London_to_Cluj.getAvailableSeats() - Paris_to_London.getAvailableSeats() - Rome_to_Madrid.getAvailableSeats();

                // management reporting displays the profit or loss and the amount of tickets sold so far
                String FinancialReportFormat = "| %-79s |%n";
                System.out.format("+---------------------------------------------------------------------------------+\n");
                System.out.format("|*********************** AVIAN FLIGHTS - FINANCIAL REPORT ************************|\n");
                System.out.format("|---------------------------------------------------------------------------------|\n");
                System.out.format(FinancialReportFormat, " Financial situation so far: " + pl + ", with " + soldTickets + " tickets sold.  ");
                System.out.format("+---------------------------------------------------------------------------------+\n");

                break;

            case 7:
                //option to exit the programm
                System.exit(0);
                break;

            default:
                //red warning message to enter a valid option
                System.out.println(RED + "Please enter a valid option 1-7");
        }
        //back to main menu
        //main menu is displayed until exit option is selected
        MainMenu();
    }

    //method to display sub-menu
    public static int subMenu() {

        //sub-menu options are displayed 1 to 5
        System.out.println("*********************************");
        System.out.println("*****     AVIAN FLIGHTS     *****");
        System.out.println("*********************************");
        System.out.println("1. London to Cluj");
        System.out.println("2. Paris to London");
        System.out.println("3. Rome to Madrid");
        System.out.println("4. \tBack");
        System.out.println("5. \tExit");

        //input protection
        //only numeric 1 to 5 values are accepted
        //red warning message if entered value is non-numeric
        int option;
        do {
            System.out.print("Please select an option: ");
            while (!keyboard.hasNextInt()) {
                System.out.println(RED + "That's not a valid option!" + COLOUR_RESET);
                keyboard.next(); // this is important!
                System.out.print("Please enter a valid option(1-5): ");
            }
            option = keyboard.nextInt();
        } while (option <= 0 || option >=6);
        
        //switch statement which returns the entered value of option
        switch (option) {

            case 1:
                return option;

            case 2:
                return option;

            case 3:
                return option;

            case 4:
                return option;

            case 5:
                System.exit(0);
                return option;

            default:
                System.out.println(RED + "Please enter a valid option 1-5: \n");
        }

        return 0;
    }

    //main method which initialises the programm by calling the main menu
    public static void main(String[] args) {

        MainMenu();
    }

}
