
class User {
    private String name;
    private Double userId;
    private Double balance;
    private  Portfolio portfolio;
    User(Double money,String name,Double userId){
        this.name= name;
        this.balance=money;
        this.userId=userId;
        this.portfolio=new Portfolio();
        
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
    Double getuserId(){
        return  userId;
    } 
    Portfolio getPortfolio(){
        return  portfolio;
    }

   
}