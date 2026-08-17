class Crypto extends Asset {
    private String networkName;

    Crypto(String symbol, String companyName, double price,String networkName) {
        super(symbol, companyName, price);
        this.networkName=networkName;
    }

    void changeCryptoPrice(double money) {
        double currentPrice = getPrice();

        currentPrice =currentPrice+money;
        setPrice(currentPrice);
    }

    public String  getNetworkName(){
        return networkName;
    }

}