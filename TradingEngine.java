import java.util.*;
class TradingEngine {
    List<Transaction> transactionHistory;
    TradingEngine(){
        transactionHistory = new ArrayList<>();
    }
    public  void placeOrder(Order order,User user){
        user.getOrderHistory().put(order.getOrderId(), order);
    }
    private boolean executeOrder(User user,Order order) throws InsufficientBalanceException, AssetNotFoundException,IllegalArgumentException,InsufficientAssetException, InvalidQuantityException{
        if(!(order.getAsset() instanceof Tradable)){
            throw new IllegalArgumentException("Asset Not Tradeable");
        }
        else if(order.getOrderType()==OrderType.BUY){
            if(user.withdrawAmount(order.getPrice()*order.getQuantity())){
                Position position = new Position(order.getAsset(), order.getQuantity(), order.getPrice());
                user.getPortfolio().updatePosition(position);
                return true;
            }
            throw new InsufficientBalanceException("Insfficient Balance");
        }
        else if(order.getOrderType()==OrderType.SELL) {
            user.getPortfolio().sellPosition(order.getAsset(),order.getQuantity() ,order.getPrice());
                user.depositAmount(order.getPrice()*order.getQuantity());
                return true;
            
           
        }
        else {
            throw new IllegalArgumentException("Enter valid Argument");
        }
        
    }
    public OrderStatus processOrder(User user, Order order) throws InsufficientBalanceException, AssetNotFoundException,IllegalArgumentException,InsufficientAssetException, InvalidQuantityException{
            
            if(order.getOrderStatus()==OrderStatus.PENDING){
                executeOrder(user, order);
              order.updateOrderStatus(OrderStatus.EXECUTED);
              Transaction transaction =new Transaction(user, order);
              transactionHistory.add(transaction);
           }
           return order.getOrderStatus(); 
    }
        public OrderStatus cancelOrder(User user, Order order) {
           if(order.getOrderStatus()==OrderStatus.PENDING){
               order.updateOrderStatus(OrderStatus.CANCELLED);
           }
        return order.getOrderStatus();
    }
    
    
}
