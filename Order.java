class Order {
    private int orderId;
    private int quantity;
    private Asset asset;
    private double price;
    private OrderType type;
    private OrderStatus status;
    
    Order(Asset asset,String s,int quantity,int orderId) throws InvalidQuantityException{
        if(quantity<=0) throw new InvalidQuantityException("Enter The Correct Quantity");
        this.quantity=quantity;
        this.asset=asset;
        this.price=asset.getPrice();
        this.status = OrderStatus.PENDING;
        this.type=OrderType.valueOf(s);
        this.orderId=orderId;
    }
    public int getQuantity(){
        return quantity;
    }
    public Asset getAsset(){
        return asset;
    }
    public double getPrice(){
        return  price;
    }
    public OrderType getOrderType(){
        return type;
    }
    public OrderStatus getOrderStatus(){
        return  status;
    }
    public void updateOrderStatus(OrderStatus status){
       this.status=status;
        
    }
    public int getOrderId(){
        return orderId;
    }
}
