class Crypto extends Asset implements Tradable {
    private String networkName;

    Crypto(String symbol, String companyName, double price,String networkName) {
        super(symbol, companyName, price);
        this.networkName=networkName;
    }


    public String  getNetworkName(){
        return networkName;
    }
    @Override
    public void canTrade(){
        System.out.println("crypto is available to trade");
    }

}