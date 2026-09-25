class Order {
    private int quantity;
    private Asset asset;
    private double price;
    private OrderType type;
    private OrderStatus status;
    Order(Asset asset,String s,int quantity){
        this.quantity=quantity;
        this.asset=asset;
        this.price=asset.getPrice();
        this.status = OrderStatus.PENDING;
        this.type=OrderType.valueOf(s);
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
}
