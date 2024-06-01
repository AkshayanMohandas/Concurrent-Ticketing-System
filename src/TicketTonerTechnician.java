public class TicketTonerTechnician implements Runnable {

    // Instance variables to store toner technician's name, service ticket machine, and thread group
    private String tonerTechnicianName;
    private ServiceTicketMachine serviceTicketMachine;
    private ThreadGroup tonerTechnicianThreadGroup;

    // Constant representing the number of retries for toner cartridge replacement
    public static final int NUMBER_OF_RETRIES = 3;

    // Constructor to initialize the toner technician with a name, service ticket machine, and thread group
    public TicketTonerTechnician(String tonerTechnicianName, ServiceTicketMachine serviceTicketMachine, ThreadGroup tonerTechnicianThreadGroup) {
        this.tonerTechnicianName = tonerTechnicianName;
        this.serviceTicketMachine = serviceTicketMachine;
        this.tonerTechnicianThreadGroup = tonerTechnicianThreadGroup;
    }

    // Override the run method as required by the Runnable interface
    @Override
    public void run() {
        // Iterate through the specified number of retries for toner cartridge replacement
        for (int i = 0; i < NUMBER_OF_RETRIES; i++) {
            // Invoke the service ticket machine to replace the toner cartridge
            serviceTicketMachine.replaceTonerCartridge();

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

        // Print a message indicating that the toner technician has finished all replacements
        System.out.println("Toner Technician " + this.tonerTechnicianName + " finished all the replacement, " +
                "cartridges used ==> " + TicketMachine.refilledPaperPackCount);
    }
}
