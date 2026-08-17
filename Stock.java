class Stock extends Asset {
    private double dividendYeild;

    Stock(String symbol, String companyName, double price,double dividendYeild) {
        super(symbol, companyName, price);
        this.dividendYeild=dividendYeild;
    }

    void changeStockPrice(double money) {
        double currentPrice = getPrice();

        currentPrice =currentPrice+money;
        setPrice(currentPrice);
    }

    public double getDividendYeild(){
        return dividendYeild;
    }

}