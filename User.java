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

    public int buyAsset(String companySymbol, Integer quantity, double price){
        double totalCost = quantity *price;
        if(totalCost>balance){
            return -1;
        }
        balance-=totalCost;
        if(portfolio.containsKey(companySymbol)){
            portfolio.put(companySymbol, portfolio.get(companySymbol) + quantity);
            return portfolio.get(companySymbol);
        } 
        else {
            portfolio.put(companySymbol, quantity);
            return portfolio.get(companySymbol);
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