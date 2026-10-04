import java.util.*; 
class User {
    private String name;
    private int userId;
    private Double balance;
    private  Portfolio portfolio;
    private HashMap<Integer,Order> orderHistory;
    private  int nextOrderId=1;
    User(Double money,String name,int userId){
        this.name= name;
        this.balance=money;
        this.userId=userId;
        this.portfolio=new Portfolio();
        this.orderHistory=new HashMap<>();
        
    }
   
    boolean withdrawAmount(Double Amount){
        if(Amount>0 && balance>=Amount){
            balance-=Amount;
            return true;
        } 
        return false;
    }
    boolean depositAmount(Double Amount){
        if(Amount>0){
            balance+=Amount;
            return true;
        }
        return false;
    }
    Double getBalance(){
        return balance;
    }
    String getName(){
        return name;
    }
    int getUserId(){
        return  userId;
    } 
    Portfolio getPortfolio(){
        return  portfolio;
    }
    HashMap<Integer, Order> getOrderHistory(){
        return orderHistory;
    }
    public  int getNextOrderId(){
        int current=nextOrderId;
        nextOrderId++;
        return current;
    }

   
}