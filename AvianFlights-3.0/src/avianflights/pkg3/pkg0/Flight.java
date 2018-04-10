
package avianflights.pkg3.pkg0;
import java.util.HashMap;
public class Flight {
    
    private final String departure;
    private final String destination;
    
    //variable that holds the value of initial number of seats available per flight
    private final int maxSeatsAvailable = 5;
    
    //variable that holds price is initialised with the starting price for a ticket
    private double price = 150;
    
    //hashmap is created to store data
    private final HashMap<String, Customer> passangers = new HashMap<>();
    
    //static variable is created to keep track of profit or loss
    //62.5 is the price Avian FLights paid for the tickets
    //15 is the total number of tickets available
    static double pl = -62.50 * 15;
    
    //method to change text colour in Java, is using ansi escape codes
    // RED changes text colour to red
    public static final String RED = "\u001B[31m";
    //COLOR_RESET  resets text colour to default
    public static final String COLOUR_RESET = "\u001B[0m";
    
    //constructor for Flight class
    public Flight(String departure, String destination){
        this.destination = destination;
        this.departure = departure;
    }
    
    
    //method to extract available seats
    public int getAvailableSeats(){
        return(maxSeatsAvailable-passangers.size());
    }
    
    //method to book a reservation/ticket
    //it checks first if there are available seats on the chosen route
    public double bookTicket(Customer cust){
        if(passangers.size() < maxSeatsAvailable){
            cust.setpaidPrice(price);
            //if there are seats available, details get saved in to hashmap
            passangers.put(cust.getppNum(), cust);
            
            //price for next ticketis increased by 28%
            price*=1.28;
            String bookConfirmationFormat = "| %-79s |%n";          
            System.out.format("+---------------------------------------------------------------------------------+\n");
            System.out.format(bookConfirmationFormat, "Booking successful for customer " +cust.getName()+ ", with passport number: " + cust.getppNum());
            System.out.format("+---------------------------------------------------------------------------------+\n");
            return cust.getpaidPrice();
        } else
            //if there are NO seats available, a message is displayed, and user is returned to main menu; 
            System.out.format("+---------------------------------------+\n");
            System.out.format("|   " + RED + "No seats available on this route!"+ COLOUR_RESET + "   |\n");
            System.out.format("+---------------------------------------+\n");
        return 0;
    }
    
    //method to cancel a booking
    public double cancelBooking(String ppNum){
        
        //string used to format output when cancellation is successful
        String bookCancellationFormat = "| %-65s | %-10s |%n"; 
        //string used to format output when no booking is found with the entered passport number
        String noPassFormat = "| %-57s |%n";
        
        //condition to check if the passport entered at the keyboard is attached to any saved booking/ticket
        // hashmap stores data in the format<key, passanger>, 
        //if passport(key in this case) is found, value is deleted from hashmap
        if(passangers.containsKey(ppNum)){
            Customer _customer_=passangers.get(ppNum);
            passangers.remove(ppNum);
            
            //price for the next ticket decreases by 28%
            price /= 1.28;
            
            //output of successful booking cancellation
            System.out.format("+--------------------------------------------------------------------------------+\n");
            System.out.format(bookCancellationFormat, "Booking has been CANCELLED for customer with passport number: ", ppNum);
            System.out.format("+--------------------------------------------------------------------------------+\n");
            System.out.format(bookCancellationFormat, "Acquisition price was:", _customer_.getpaidPrice());
            System.out.format("+--------------------------------------------------------------------------------+\n");
            
            return 
                    //the method returns the price paid for the ticket
                    _customer_.getpaidPrice();
        } else
            
            //format output for unsuccessful cancellation; 
            //RED constant is used to change text colour to red;
            //Colour_RESET is used to reset text coulor to default; 
            //needed because the table's margins are different colour than the text;
            System.out.format("+--------------------------------------------------+\n");
            System.out.format(noPassFormat, RED + "There is no booking for passport number: " + ppNum + COLOUR_RESET);
            System.out.format("+--------------------------------------------------+\n");

            return 0;
    }
    
    //method to extract price of ticket
    public double getPrice(){
        return price;
    }
    
    //method to extract profit or loss
    public double ProfitOrLoss(){
      return pl;  
    }
    
}
