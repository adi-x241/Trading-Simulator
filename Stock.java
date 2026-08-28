class Stock extends Asset {
    private double dividendYield;

    Stock(String symbol, String companyName, double price,double dividendYield) {
        super(symbol, companyName, price);
        this.dividendYield=dividendYield;
    }

    public double getDividendYield(){
        return dividendYield;
    }

}