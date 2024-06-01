public class TicketPrintingSystem {

    public static void main(String[] args) {
        // Print a welcome message to the console
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println("Welcome to the Ticket Machine! \n");

        // Ticket objects with passenger information
        Ticket ticket = new Ticket("PASSENGER1", "Cavendish", "10:00");
        Ticket ticket2 = new Ticket("PASSENGER2", "Harrow", "14:00");
        Ticket ticket3 = new Ticket("PASSENGER3", "Marylebone", "16:00");
        Ticket ticket4 = new Ticket("PASSENGER4", "Regent", "16:00");

        // TicketMachine object with initial parameters
        ServiceTicketMachine ticketMachine = new TicketMachine(20, 15, 0);

        // Array of ThreadGroups for passengers and technicians
        ThreadGroup[] ticketMachineThreadGroups = new ThreadGroup[2];
        ticketMachineThreadGroups[0] = new ThreadGroup("Passenger Thread Group");
        ticketMachineThreadGroups[1] = new ThreadGroup("Technician Thread Group");

        // Array of Runnables for passengers and technicians
        Runnable[] ticketMachineRunnable = new Runnable[6];
        ticketMachineRunnable[0] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 2, ticket);
        ticketMachineRunnable[1] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 3, ticket2);
        ticketMachineRunnable[2] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 4, ticket3);
        ticketMachineRunnable[3] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 5, ticket4);
        ticketMachineRunnable[4] = new TicketPaperTechnician("PaperTechnician", ticketMachine, ticketMachineThreadGroups[1]);
        ticketMachineRunnable[5] = new TicketTonerTechnician("TonerTechnician", ticketMachine, ticketMachineThreadGroups[1]);

        // Array of Threads for passengers and technicians
        Thread[] ticketMachineThreads = new Thread[6];
        ticketMachineThreads[0] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[0], "PASSENGER1");
        ticketMachineThreads[1] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[1], "PASSENGER2");
        ticketMachineThreads[2] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[2], "PASSENGER3");
        ticketMachineThreads[3] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[3], "PASSENGER4");
        ticketMachineThreads[4] = new Thread(ticketMachineThreadGroups[1], ticketMachineRunnable[4], "PaperTechnician");
        ticketMachineThreads[5] = new Thread(ticketMachineThreadGroups[1], ticketMachineRunnable[5], "TonerTechnician");

        // Start all threads and print their states before they start
        for (Thread thread : ticketMachineThreads) {
            System.out.println(thread.getName() + " state before start: " + thread.getState());
            thread.start();
        }
        System.out.println("\nThere are " + ticketMachineThreadGroups[0].activeCount() + " passengers ");
        System.out.println("There are " + ticketMachineThreadGroups[1].activeCount() + " technicians\n");

        // Wait for all threads to finish
        for (Thread thread : ticketMachineThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("");
        // Print the state of each thread after they have finished
        for (Thread thread : ticketMachineThreads) {
            System.out.println(thread.getName() + " state after finish: " + thread.getState());
        }

        System.out.println("\nProgram Terminated");
        System.out.println("---------------------------------------------------------------------------------\n");

    }
}


