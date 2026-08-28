class Crypto extends Asset {
    private String networkName;

    Crypto(String symbol, String companyName, double price,String networkName) {
        super(symbol, companyName, price);
        this.networkName=networkName;
    }


    public String  getNetworkName(){
        return networkName;
    }

}