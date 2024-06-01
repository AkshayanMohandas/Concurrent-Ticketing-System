public class TicketPaperTechnician implements Runnable {

    // Instance variables to store paper technician's name, service ticket machine, and thread group
    private String ticketTechnicianName;
    private ServiceTicketMachine serviceTicketMachine;
    private ThreadGroup ticketTechnicianThreadGroup;

    // Constant representing the number of retries for paper refill
    public static final int NUMBER_OF_RETRIES = 3;

    // Constructor to initialize the paper technician with a name, service ticket machine, and thread group
    public TicketPaperTechnician(String ticketTechnicianName, ServiceTicketMachine serviceTicketMachine, ThreadGroup ticketTechnicianThreadGroup) {
        this.ticketTechnicianName = ticketTechnicianName;
        this.serviceTicketMachine = serviceTicketMachine;
        this.ticketTechnicianThreadGroup = ticketTechnicianThreadGroup;
    }

    // Override the run method as required by the Runnable interface
    @Override
    public void run() {
        // Iterate through the specified number of retries for paper refill
        for (int i = 0; i < NUMBER_OF_RETRIES; i++) {
            // Invoke the service ticket machine to refill paper
            serviceTicketMachine.refillPaper();

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

        // Print a message indicating that the paper technician has finished all refills
        System.out.println("Paper Technician " + this.ticketTechnicianName + " finished all the replacement, " +
                "packs of paper used ==> " + TicketMachine.replacedTonerCount);
    }
}
