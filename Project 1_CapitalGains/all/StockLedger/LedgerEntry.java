package all.StockLedger;

public class LedgerEntry {
    private final String stockSymbol;
    private int totalShares;
    private double totalCost;

    public LedgerEntry(String stockSymbol) {
        this.stockSymbol = stockSymbol;
        this.totalShares = 0;
        this.totalCost = 0.0;
    }

    public void addShares(int sharesBought, double pricePerShare) {
        totalShares += sharesBought;
        totalCost += sharesBought * pricePerShare;
    }

    public double sellShares(int sharesSold, double pricePerShare) {
        if (sharesSold > totalShares) {
            throw new IllegalArgumentException("Not enough shares to sell.");
        }
        double averageCostPerShare = totalCost / totalShares;
        totalShares -= sharesSold;

        if (totalShares == 0) {
            totalCost = 0; // Reset cost if all shares sold
        } else {
            totalCost -= sharesSold * averageCostPerShare; // Adjust cost for remaining shares
        }

        return (sharesSold * pricePerShare) - (sharesSold * averageCostPerShare); // Capital gain/loss
    }

    public int getTotalShares() {
        return totalShares;
    }

    public double getTotalValue() {
        return totalShares > 0 ? (totalShares * (totalCost / totalShares)) : 0;
    }

    public void printDetails() {
        System.out.printf("Stock: %s, Shares: %d, Average Cost: %.2f%n", stockSymbol, totalShares, totalShares > 0 ? totalCost / totalShares : 0);
    }
}
