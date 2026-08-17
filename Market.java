import java.util.HashMap;
class Market {
    HashMap<String, Stock> availableStocks;
    HashMap<String,Crypto> availableCrypto;
    Market(){
        availableStocks = new HashMap<>();
        availableCrypto = new HashMap<>();
    }
    public void addStock(Stock stock){
        availableStocks.put(stock.getSymbol(), stock);
    }
    public void addCrypto(Crypto crypto){
        availableCrypto.put(crypto.getSymbol(), crypto);
    }
    public Stock getStock(String symbol){
        return availableStocks.get(symbol);
    }
    public Crypto getCrypto(String symbol){
        return  availableCrypto.get(symbol);
    }
}
