class Stock{
    private  String symbol;
    private String companyName;
    private Double price;

    Stock(String symbol, String companyname,Double price){
        this.symbol=symbol;
        this.companyName=companyname;
        this.price= price;
    }
    void SetValue(Double money){
        if(money>0){
            this.price=money;
        }
    }
    Double GetValue(){
        return price;
    }
    String GetSymbol(){
        return symbol;
    }
    String GetCompanyName(){
        return companyName;
    }
}