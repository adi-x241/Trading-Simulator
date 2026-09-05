
class Stock extends Asset implements Tradable {
    private double dividendYield;

    Stock(String symbol, String companyName, double price,double dividendYield) {
        super(symbol, companyName, price);
        this.dividendYield=dividendYield;
    }

    public double getDividendYield(){
        return dividendYield;
    }

    @Override 
    public void canTrade(){
        System.out.println("Stock is available to trade");
    }

}