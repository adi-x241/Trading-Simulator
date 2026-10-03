import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        User user1 = new User(2344.5,"Aditya",101 );
        Market market = new Market();
        Stock stock1 = new Stock("@","apple",2345,2.5);
        Crypto crypto1 = new Crypto("#", "SOLANA", 114920, "SOL MAINET" );
        market.addAsset(crypto1);
        market.addAsset(stock1);

        System.out.println("=".repeat(40));
        System.out.println("           TRADING SIMULATOR");
        System.out.println("=".repeat(40));
        int choice,option;

        do {
            System.out.println(" 1. USER");
            System.out.println(" 2. Market/Admin");
            System.out.println(" 3. Exit");
            System.out.print("Enter The Choice :");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                        System.out.println("=".repeat(40));
                        System.out.println("               USER MENU");
                        System.out.println("=".repeat(40));
                        System.out.println(" 1. View Balance");
                        System.out.println(" 2. View portfolio");
                        System.out.println(" 3. View Market");
                        System.out.println(" 4. Buy Asset");
                        System.out.println(" 5. Sell Asset");
                        System.out.println(" 6. View Order History");
                        System.out.println(" 7. Back");

                    do{
                       System.out.print("Enter The Option :");
                       option=sc.nextInt(); 
                        
                        switch (option) {
                            case 1:
                                System.out.println("User Balance :"+user1.getBalance());
                                break;
                        
                            case 2:
                                System.out.println("User Portfolio :"+user1.getPortfolio().getpositions());
                                break;
                            case 3:
                                System.out.println("Market :"+market.getMarket());
                        }


                    }while(option>0 && option<8);
                    

                    break;

                case 2:
                    break;

                case 3:
                    break;
            }

        } while (choice > 0 && choice < 4);
    }
}