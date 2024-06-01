public class Passenger implements Runnable {

    // Instance variables to store passenger thread group, service ticket machine, number of tickets to print, and a reference ticket
    private ThreadGroup passengerThreadGroup;
    private ServiceTicketMachine machine;
    private Ticket ticket;
    private int noOfTickets;
    private int ticketPurchaseCount;

    // Constructor to initialize the passenger with a thread group, service ticket machine, number of tickets, and a reference ticket
    public Passenger(ThreadGroup passengerThreadGroup, ServiceTicketMachine machine, int noOfTickets, Ticket ticket) {
        this.passengerThreadGroup = passengerThreadGroup;
        this.machine = machine;
        this.noOfTickets = noOfTickets;
        this.ticket = ticket;
        this.ticketPurchaseCount = 0;
    }

    @Override
    public void run() {
        // Array to store tickets printed by the passenger
        Ticket[] ticketList = new Ticket[noOfTickets];

        // Loop to print the specified number of tickets
        for (int i = 0; i < noOfTickets; i++) {
            // Invoke the service ticket machine to print a ticket using the reference ticket
            machine.printTicket(this.ticket);

            // Increment the ticket purchase count
            ticketPurchaseCount++;

            // Creating a new ticket with the same details as the reference ticket and store it in the array
            ticketList[i] = new Ticket(ticket.getTicketNumber(), ticket.getPassengerID(), ticket.getDestination(), ticket.getTime());

            // Generate a random wait time between 1 and 1000 milliseconds
            int waitTime = ((int) (Math.random() * (1000 - 1))) + 1;

            // Pause the thread execution for the generated wait time
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                // Throw a runtime exception if the thread is interrupted during sleep
                throw new RuntimeException(e);
            }
        }
    }
}
