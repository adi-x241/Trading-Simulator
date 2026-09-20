import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
class Portfolio {
    
    private HashMap<Asset,Position> portfolio;

    Portfolio(){
        this.portfolio=new HashMap<>();
    }
    
    private boolean containsAsset(Asset asset){
        return  portfolio.containsKey(asset);
    }
    public boolean updatePosition(Position position){
        if(!portfolio.containsKey(position.getAsset())){
            portfolio.put(position.getAsset(),position);
            return true;
        }
        Position existingPosition =  portfolio.get(position.getAsset());
        existingPosition.addQuantity(position.getQuantity(),position.getAveragePrice());
        return true;
    }

    public boolean sellPosition(Asset asset, int quantity, double price){
        if(!portfolio.containsKey(asset)) return  false;
        Position existingPosition = portfolio.get(asset);

        boolean removed = existingPosition.removeQuantity(quantity, price);

        if (!removed) {
           return false;
        }

        if(existingPosition.getQuantity() == 0){
            portfolio.remove(existingPosition.getAsset());
            return true;
        }
        return true;
    }
    public Position getPosition(Asset asset){
        return portfolio.get(asset);
    }
    public Collection<Position> getpositions(){
        return portfolio.values();
    }
    public double netValue(){
        double totalValue=0;
        for(Map.Entry<Asset,Position> entry:portfolio.entrySet()){
            totalValue+=entry.getKey().getPrice()*entry.getValue().getQuantity();
        }
        return  totalValue;
    }
    public double netProfit_Loss(){
        double totalprofit_loss=0;
        for(Map.Entry<Asset,Position> entry:portfolio.entrySet()){
            totalprofit_loss+=(entry.getKey().getPrice()-entry.getValue().getAveragePrice())*entry.getValue().getQuantity();
        }
        return  totalprofit_loss;
    }

}
