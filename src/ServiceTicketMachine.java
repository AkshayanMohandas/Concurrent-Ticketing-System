public interface ServiceTicketMachine extends Machine {

    // Constants representing the maximum paper tray capacity and sheets per pack
    int FULL_PAPER_TRAY = 20;
    int SHEETS_PER_PACK = 5;

    // Constants representing the full toner level and minimum toner level required for replacement
    int FULL_TONER_LEVEL = 10;
    int MINIMUM_TONER_LEVEL = 10;

    // Method signature for replacing the toner cartridge
    void replaceTonerCartridge();

    // Method signature for refilling paper
    void refillPaper();

    // Method signature for getting the current paper level
    int getPaperLevel();

    // Method signature for getting the current toner level
    int getTonerLevel();
}
