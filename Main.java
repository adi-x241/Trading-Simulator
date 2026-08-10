public class Main {
    public static void main(String[] args) {
       
        Market newMarket = new Market();
        
       
        Stock stock1 = new Stock("APPLE", "APPLE INC", 333.2);
        Stock stock2 = new Stock("GOOGLE", "GOOGLE.COM", 345.0);
        Stock stock3 = new Stock("BIRYANI", "PATAKI", 20.0);
        
        newMarket.addStock(stock1);
        newMarket.addStock(stock2);
        newMarket.addStock(stock3);
        
        
        User user1 = new User(2000000.1, "ADITYA");
        
        
        double currentPrice = newMarket.getStock("APPLE").getPrice();
        System.out.println("Current price of APPLE: $" + currentPrice);
        
       
        int value = user1.buyStock("APPLE", 20, currentPrice);
        
        
        if (value == -1) {
            System.out.println("Transaction Failed: Insufficient balance.");
        } else {
            System.out.println("Success! Aditya now owns " + value + " shares of APPLE.");
            System.out.println("Updated Portfolio: " + user1.getPortfolio());
        }
    }
}