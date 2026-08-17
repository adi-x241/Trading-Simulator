public class Main {
    public static void main(String[] args) {
       
        Market newMarket = new Market();
        
       
        Stock stock1 = new Stock("APPLE", "APPLE INC", 333.2,50);
        Crypto crypto1 = new Crypto("GOOGLE", "GOOGLE.COM", 345.0,"hello");
        
        
        newMarket.addStock(stock1);
        newMarket.addCrypto(crypto1);
        
        
        User user1 = new User(2000000.1, "ADITYA");
        
        
        double currentPrice = newMarket.getStock("APPLE").getPrice();
    
        System.out.println("Current price of APPLE: $" + currentPrice);

        currentPrice = newMarket.getCrypto("GOOGLE").getPrice();
        System.out.println("current price of GOOGLE IS"+currentPrice);
        
       
        int value = user1.buyStock("APPLE", 20, currentPrice);
        int value1 = user1.buyCrypto("GOOGLE", 2, currentPrice);
        
        
        if (value == -1) {
            System.out.println("Transaction Failed: Insufficient balance.");
        } else {
            System.out.println("Success! Aditya now owns " + value + " shares of APPLE.");
            System.out.println("Updated Portfolio: " + user1.getPortfolio());
        }
        if (value1 == -1) {
            System.out.println("Transaction Failed: Insufficient balance.");
        } else {
            System.out.println("Success! Aditya now owns " + value + " shares of APPLE.");
            System.out.println("Updated Portfolio: " + user1.getPortfolio());
        }
    }
}