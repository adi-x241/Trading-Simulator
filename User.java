class User {
    private String name;
    private Double balance;

    User(Double money,String name){
        this.name= name;
        this.balance=money;
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
}