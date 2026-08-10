import java.util.HashMap;
class Market {
    HashMap<String, Stock> availableStocks;
    Market(){
        availableStocks = new HashMap<>();
    }
    public void addStock(Stock stock){
        availableStocks.put(stock.getSymbol(), stock);
    }
    public Stock getStock(String Symbol){
        return availableStocks.get(Symbol);
    }
}
