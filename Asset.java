abstract class Asset {
    private String symbol;
    private String companyName;
    private double price;

    Asset(String symbol,String name, double price ) throws InvalidPriceException{
        this.symbol=symbol;
        this.companyName=name;
        if(price<=0) throw new InvalidPriceException("Enter Correct Price");
        this.price=price;
    }
    
    public boolean setPrice(double money) throws InvalidPriceException {
        if (money > 0) {
            this.price = money;
            return true;
        }
        throw new InvalidPriceException("Enter valid Price");
        
    }
    public  boolean changeAssetPrice(double money)throws InvalidPriceException{
        double currentPrice = getPrice();
        currentPrice =currentPrice+money;
        return setPrice(currentPrice);
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

    @Override 
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(!(obj instanceof Asset)) return false;
        Asset other = (Asset) obj;
        return  this.getSymbol().equals(other.getSymbol());
    }
    @Override 
    public int hashCode(){
        return getSymbol().hashCode();
    }

}