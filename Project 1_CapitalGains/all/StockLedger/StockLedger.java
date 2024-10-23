package all.StockLedger;
import java.util.HashMap;

public class StockLedger implements StockLedgerInterface {
    private  HashMap<String, LedgerEntry> ledger;

    public StockLedger() {
        this.ledger = new HashMap<>();
    }

    @Override
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {
        stockSymbol = stockSymbol.toUpperCase();
        LedgerEntry entry = ledger.getOrDefault(stockSymbol, new LedgerEntry(stockSymbol));
        entry.addShares(sharesBought, pricePerShare);
        ledger.put(stockSymbol, entry);
    }

    @Override
    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        stockSymbol = stockSymbol.toUpperCase();
        if (!ledger.containsKey(stockSymbol)) {
            throw new IllegalArgumentException("Stock not found in ledger.");
        }

        LedgerEntry entry = ledger.get(stockSymbol);
        double capitalGain = entry.sellShares(sharesSold, pricePerShare);

        if (entry.getTotalShares() == 0) {
            ledger.remove(stockSymbol); // Remove entry if no shares left
        }

        return capitalGain;
    }

    @Override
    public boolean contains(String stockSymbol) {
        return ledger.containsKey(stockSymbol.toUpperCase());
    }

    @Override
    public LedgerEntry getEntry(String stockSymbol) {
        return ledger.get(stockSymbol.toUpperCase());
    }

    public void printLedger() {
        System.out.println("---- Stock Ledger ----");
        for (LedgerEntry entry : ledger.values()) {
            entry.printDetails();
        }
    }

}
