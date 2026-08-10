class Stock {
    private String symbol;
    private String companyName;
    private Double price;

    Stock(String symbol, String companyName, Double price) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.price = price;
    }

    void setPrice(Double money) {
        if (money > 0) {
            this.price = money;
        }
    }

    Double getPrice() {
        return price;
    }

    String getSymbol() {
        return symbol;
    }

    String getCompanyName() {
        return companyName;
    }
}