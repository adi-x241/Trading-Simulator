import java.util.HashMap;
class Market {
    HashMap<String,Asset> availableAssets;

    Market(){
        availableAssets = new HashMap<>();
    }
    public void addAsset(Asset asset){
        availableAssets.put(asset.getSymbol(),asset);// saves thes symbol and key as which type of asset
    }
    public Asset getAsset(String symbol){
         return availableAssets.get(symbol);
    }
}
