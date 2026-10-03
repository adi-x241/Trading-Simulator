class Position {
    private Asset asset;
    private int quantity;
    private double averagePrice;

    Position(Asset asset, int quantity, double averagePrice){
        this.asset=asset;
        this.quantity=quantity;
        this.averagePrice=averagePrice;
    }
    public Asset getAsset(){
        return asset;
    }  
    public int getQuantity(){
        return quantity;
    } 
    public double getAveragePrice(){
        return averagePrice;
    }
    public boolean addQuantity(int quantity ,double price) throws InvalidQuantityException{
        if(quantity>0 && price>0){
            this.averagePrice=(this.averagePrice*this.quantity+price*quantity)/(this.quantity+quantity);
            this.quantity+=quantity;
            return  true;
        }
        throw new InvalidQuantityException("Enter The Correct value");
    }
    public boolean removeQuantity(int quantity,double price) throws InvalidQuantityException,InsufficientAssetException{
        if(quantity>this.quantity){
            throw new InsufficientAssetException("Enter The Valid Number of Asset");
        }
        if(quantity>0 && price>0){
            this.quantity-=quantity;
            return  true;
        }
        
        throw new InvalidQuantityException("Enter The Valid Values");
    }
    
}

