package all.StockLedger;
import all.StockLedger.src.StockLedger;

public class Main {
    public static void main(String[] args) {
        // Initialize the StockLedger
        StockLedger ledger = new StockLedger();

        // Record stock purchases
        ledger.buy("AAPL", 20, 45.0);
        ledger.buy("AAPL", 20, 75.0);
        ledger.buy("MSFT", 20, 95.0);

        // Print the stock ledger
        ledger.printLedger();

        // Print stock entries in descending order
        System.out.println("\nDescending Order of Stock Purchases:");
        for (LedgerEntry entry : ledger.getEntriesInDescendingOrder()) {
            entry.printDetails();
        }
    }
}
