public class Main {
    public static void main(String[] args) {
       
        Market newMarket = new Market();
        
       
        Asset asset1 = new Stock("APPLE", "APPLE INC", 333.2,50);
        Asset asset2 = new Crypto("GOOGLE", "GOOGLE.COM", 345.0,"hello");
        newMarket.addAsset(asset1);
        newMarket.addAsset(asset2);

        System.out.println("type asset 2 is"+newMarket.getAsset("APPLE"));
        
    }
}