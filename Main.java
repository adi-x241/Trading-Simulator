public class Main{
    public static void main(String[] args){
        Stock Apple = new Stock("Apple","Apple inc.",1000.12);
        System.out.println("Stock Symbol: " + Apple.GetSymbol());
        System.out.println("Company Name: " + Apple.GetCompanyName());
        System.out.println("Current Price: " + Apple.GetValue());

        User user1 = new User(50.0,"Aditya");
        System.out.println("User Name: " + user1.getName());
        System.out.println("User Balance: " + user1.getBalance());
        user1.depositAmount(20.22);
        System.out.println("User Balance after deposit: " + user1.getBalance());
        user1.withdrawAmount(30.0);
        System.out.println("User Balance after withdrawal: " + user1.getBalance());
        
    }
}