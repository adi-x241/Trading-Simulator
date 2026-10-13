import  java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
class Market implements  Serializable{
    private HashMap<String,Asset> availableAssets;
    Market(){
        availableAssets = new HashMap<>();
    }
    public void addAsset(Asset asset){
        if(!availableAssets.containsKey(asset.getSymbol())){
            availableAssets.put(asset.getSymbol(),asset);
        }
    }
    public Asset getAsset(String symbol) throws AssetNotFoundException{
           if(availableAssets.containsKey(symbol)){
             return availableAssets.get(symbol);
           }
           throw new AssetNotFoundException("Asset is Not Present in Market");
    }
    public HashMap<String, Asset> getMarket(){
        return availableAssets;
    }
    public Asset getAsset(Asset asset){
        if(availableAssets.containsKey(asset.getSymbol())){
            return availableAssets.get(asset.getSymbol());
        }
        return  null;
    }

}
