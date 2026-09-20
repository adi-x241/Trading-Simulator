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
}
