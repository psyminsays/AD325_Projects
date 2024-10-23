package all.StockLedger;

public class StockPurchase extends LedgerEntry {

    public double pricePerShare;
    private final int shares;

    public StockPurchase(String stockSymbol, int sharesBought, double pricePerShare) {
        super(stockSymbol);
        this.shares = sharesBought;
        this.pricePerShare = pricePerShare;
    }
    /**
    @return return the amount of shares and total cost.
     */
    @Override
    public String toString() {
        return pricePerShare + " (" + shares + " shares)";
    }
}
