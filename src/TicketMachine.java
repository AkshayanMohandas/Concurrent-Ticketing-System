public class TicketMachine implements ServiceTicketMachine {
    private int currentTonerLevel;
    private int currentPaperLevel;
    public static int refilledPaperPackCount = 0;
    public static int replacedTonerCount = 0;
    private int printedTickets;

    public TicketMachine(int currentTonerLevel, int currentPaperLevel, int printedTickets) {
        this.currentTonerLevel = currentTonerLevel;
        this.currentPaperLevel = currentPaperLevel;
        this.printedTickets = printedTickets;
    }

    @Override
    public synchronized void printTicket(Ticket ticket) {
        while (this.currentPaperLevel < 1 || this.currentTonerLevel < 1) {
            System.out.println("Cannot Print the ticket since the resources are not available: paper level ==> " + currentPaperLevel + " toner level ==> " + currentTonerLevel);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.currentPaperLevel -= 1;
        this.currentTonerLevel -= 1;
        this.printedTickets += 1;
        ticket.setTicketNumber(printedTickets);

        ticket.incrementTicketPurchaseCount();

        System.out.println("Ticket print was success. Ticket Details ==> " + Thread.currentThread().getName() + " ==> " + ticket);
        notifyAll();
    }

    @Override
    public synchronized void replaceTonerCartridge() {
        while (this.currentTonerLevel >= MINIMUM_TONER_LEVEL) {
            System.out.println("Attempt to toner replacement failed by " + Thread.currentThread().getName() + " since required level is available ==> Toner Level: " + this.currentTonerLevel);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.currentTonerLevel = FULL_TONER_LEVEL;
        replacedTonerCount += 1;
        System.out.println("Toner replacement success by " + Thread.currentThread().getName() + "  -> Toner Level: " + this.currentTonerLevel);
        notifyAll();
    }

    @Override
    public synchronized void refillPaper() {
        while (!(this.currentPaperLevel <= (FULL_PAPER_TRAY - SHEETS_PER_PACK))) {
            System.out.println("Attempt to paper replacement failed by " + Thread.currentThread().getName() + " since required level is available ==> Paper Level: " + this.currentPaperLevel);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.currentPaperLevel += SHEETS_PER_PACK;
        this.refilledPaperPackCount += 1;
        System.out.println("Paper replacement success by " + Thread.currentThread().getName() + "  -> Paper Level: " + this.currentPaperLevel);
        notifyAll();
    }

    @Override
    public int getPaperLevel() {
        return currentPaperLevel;
    }

    @Override
    public int getTonerLevel() {
        return currentTonerLevel;
    }
}
