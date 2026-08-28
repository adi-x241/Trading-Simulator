public abstract class Asset {
    private String symbol;
    private String companyName;
    private double price;

    Asset(String symbol,String name, double price ){
        this.symbol=symbol;
        this.companyName=name;
        this.price=price;
    }
    
    public void setPrice(double money) {
        if (money > 0) {
            this.price = money;
        }
    }
    public  void changeAssetPrice(double money) {
        double currentPrice = getPrice();
        currentPrice =currentPrice+money;
        setPrice(currentPrice);
    }

    public double getPrice(){
        return price;
    }
    public String getName(){
        return companyName;
    }
    public String getSymbol(){
        return symbol;
    }

}