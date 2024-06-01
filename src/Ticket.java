public class Ticket {

    // Instance variables to store ticket information: ticketNumber, passengerID, destination, and time
    private int ticketNumber;
    private String passengerID;
    private String destination;
    private String time;
    private int ticketPurchaseCount;

    // Constructor for creating a ticket with a specified ticket number, passenger ID, destination, and time
    public Ticket(int ticketNumber, String passengerID, String destination, String time) {
        this.ticketNumber = ticketNumber;
        this.passengerID = passengerID;
        this.destination = destination;
        this.time = time;
        this.ticketPurchaseCount = 0; // Initialize purchase count to 0
    }

    // Constructor for creating a ticket without specifying a ticket number
    public Ticket(String passengerID, String destination, String time) {
        this.passengerID = passengerID;
        this.destination = destination;
        this.time = time;
        this.ticketPurchaseCount = 0; // Initialize purchase count to 0
    }

    // Getter method to retrieve the ticket number
    public int getTicketNumber() {
        return ticketNumber;
    }

    // Getter method to retrieve the passenger ID
    public String getPassengerID() {
        return passengerID;
    }

    // Getter method to retrieve the destination
    public String getDestination() {
        return destination;
    }

    // Getter method to retrieve the time
    public String getTime() {
        return time;
    }

    // Setter method to set the ticket number
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    // Method to increment the ticket purchase count
    public void incrementTicketPurchaseCount() {
        this.ticketPurchaseCount++;
    }

    // Override the toString method to provide a string representation of the ticket
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", passengerID='" + passengerID + '\'' +
                ", destination='" + destination + '\'' +
                ", time='" + time + '\'' +
                ", ticketPurchaseCount=" + ticketPurchaseCount +
                '}';
    }
}
