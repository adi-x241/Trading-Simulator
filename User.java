import java.util.HashMap;
class User {
    private String name;
    private Double balance;

    private HashMap<String,Integer> portfolio;

    User(Double money,String name){
        this.name= name;
        this.balance=money;
        this.portfolio = new HashMap<>();
    }

    public int buyStock(String companyName, Integer quantity, Double price){
        double totalCost = quantity *price;
        if(totalCost>balance){
            return -1;
        }
        balance-=totalCost;
        if(portfolio.containsKey(companyName)){
            portfolio.put(companyName, portfolio.get(companyName) + quantity);
            return portfolio.get(companyName);
        } 
        else {
            portfolio.put(companyName, quantity);
            return portfolio.get(companyName);
        }
       
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

    public HashMap<String, Integer> getPortfolio() {
      return portfolio;
    }
}