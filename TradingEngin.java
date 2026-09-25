import java.util.*;
class TradingEngin {
    List<Transaction> transactionHistory;
    TradingEngin(){
        transactionHistory = new ArrayList<>();
    }
    private boolean executeOrder(User user,Order order){
        if(!(order.getAsset() instanceof Tradable)){
            return false;
        }
        else if(order.getOrderType()==OrderType.BUY){
            if(user.withdrawAmount(order.getPrice()*order.getQuantity())){
                Position position = new Position(order.getAsset(), order.getQuantity(), order.getPrice());
                user.getPortfolio().updatePosition(position);
                return true;
            }
            return false;
        }
        else if(order.getOrderType()==OrderType.SELL){
            if(user.getPortfolio().sellPosition(order.getAsset(),order.getQuantity() ,order.getPrice())){
                user.depositAmount(order.getPrice()*order.getQuantity());
                return true;
            }
            return false;
        }
        return false;
        
    }
    public OrderStatus processOrder(User user, Order order){
        if(executeOrder(user, order)){
            order.updateOrderStatus(OrderStatus.EXECUTED);
                Transaction transaction =new Transaction(user, order);
                transactionHistory.add(transaction);
            return order.getOrderStatus();
        }
        order.updateOrderStatus(OrderStatus.CANCELLED);
        return order.getOrderStatus();
    }
    
    
}
