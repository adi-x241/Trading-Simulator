
import java.util.Collection;
import java.util.HashMap;
class Market {
    private HashMap<String,Asset> availableAssets;
    Market(){
        availableAssets = new HashMap<>();
    }
    public void addAsset(Asset asset){
        if(!availableAssets.containsKey(asset.getSymbol())){
            availableAssets.put(asset.getSymbol(),asset);
        }
    }
    public Asset getAsset(String symbol){
         return availableAssets.get(symbol);
    }
    public HashMap<String, Asset> getMarket(){
        return availableAssets;
    }
    
    

}
