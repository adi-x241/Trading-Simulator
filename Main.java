
import java.io.File;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        File file = new File("simulator.dat");

        User user1;
        Market market;
        TradingEngine engine;

        if (file.exists()) {
            Object[] data = Storage.load();
            user1 = (User) data[0];
            market = (Market) data[1];
            engine = (TradingEngine) data[2];
            System.out.println("Saved data loaded successfully.");
        } else {
            user1 = new User(23444444.2, "Aditya", 101);

            market = new Market();
            Stock stock1 = new Stock("@", "apple", 2345, 2.5);
            Crypto crypto1 = new Crypto("#", "SOLANA", 114920, "SOL MAINET");

            market.addAsset(crypto1);
            market.addAsset(stock1);

            engine = new TradingEngine();
            System.out.println("Starting with default data.");
        }

        OrderStatus orderStatus;

        System.out.println("=".repeat(40));
        System.out.println("           TRADING SIMULATOR");
        System.out.println("=".repeat(40));

        int choice;
        boolean success = true;
        boolean choiceDone = false;

        do {
            System.out.println("1. USER");
            System.out.println("2. Market/Admin");
            System.out.println("3. Exit");
            System.out.print("Enter The Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    int userChoice;
                    do {
                        System.out.println("=".repeat(40));
                        System.out.println("USER MENU");
                        System.out.println("=".repeat(40));
                        System.out.println("1. Add Balance / View Balance");
                        System.out.println("2. View Portfolio");
                        System.out.println("3. View Market");
                        System.out.println("4. Buy Asset");
                        System.out.println("5. Sell Asset");
                        System.out.println("6. View Order History");
                        System.out.println("7. Back");
                        System.out.print("Enter The Option: ");
                        userChoice = sc.nextInt();

                        switch (userChoice) {
                            case 1: {
                                System.out.print("Enter The Amount: ");
                                double amount = sc.nextDouble();

                                if (user1.depositAmount(amount)) {
                                    System.out.println("Amount Added Successfully");
                                } else {
                                    System.out.println("Invalid Amount");
                                }

                                System.out.println("User Balance: " + user1.getBalance());
                                break;
                            }

                            case 2:
                                System.out.println("User Portfolio:");

                                for (Position position : user1.getPortfolio().getpositions()) {
                                    System.out.println("=".repeat(40));
                                    System.out.println("Asset: " + position.getAsset().getName());
                                    System.out.println("Quantity: " + position.getQuantity());
                                    System.out.println("Average Price: " + position.getAveragePrice());
                                    System.out.println(
                                            "Asset Net Value :" + position.getQuantity() * position.getAveragePrice());
                                    System.out.println("=".repeat(40));
                                }
                                System.out.println("Net Value of Portfolio :" + user1.getPortfolio().netValue());
                                break;

                            case 3:
                                System.out.println("Market:");
                                for (Map.Entry<String, Asset> entry : market.getMarket().entrySet()) {
                                    Asset asset = entry.getValue();
                                    System.out.println("=".repeat(40));
                                    System.out.println("Asset: " + asset.getName());
                                    System.out.println("Symbol: " + entry.getKey());
                                    System.out.println("Price: " + asset.getPrice());
                                    System.out.println("=".repeat(40));
                                }
                                break;

                            case 4: {
                                System.out.println("Market:");
                                for (Map.Entry<String, Asset> entry : market.getMarket().entrySet()) {
                                    Asset asset = entry.getValue();
                                    System.out.println(asset.getSymbol() + " -> "
                                            + asset.getName() + " -> " + asset.getPrice());
                                }

                                success = true;

                                do {
                                    String symbol = null;
                                    boolean invalid = false;
                                    do {
                                        try {
                                            System.out.print("Enter The Symbol Of Company: ");
                                            symbol = sc.next();
                                            market.getAsset(symbol);
                                            invalid = true;

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            invalid = false;

                                        }
                                    } while (!invalid);

                                    System.out.print("How many assets do you want to purchase: ");
                                    int quantity = sc.nextInt();

                                    try {
                                        Order order = new Order(
                                                market.getAsset(symbol), "BUY",
                                                quantity, user1.getNextOrderId());

                                        engine.placeOrder(order, user1);
                                        choiceDone = false;

                                        do {
                                            System.out.println("1. BUY");
                                            System.out.println("2. CANCEL");
                                            System.out.print("Enter the choice: ");

                                            int tradeChoice = sc.nextInt();

                                            switch (tradeChoice) {
                                                case 1:
                                                    orderStatus = engine.processOrder(user1, order);

                                                    if (orderStatus == OrderStatus.EXECUTED) {
                                                        System.out.println("Order Executed");
                                                        success = false;
                                                        choiceDone = true;
                                                    }
                                                    break;

                                                case 2:
                                                    orderStatus = engine.cancelOrder(user1, order);

                                                    if (orderStatus == OrderStatus.CANCELLED) {
                                                        System.out.println("Order Cancelled");
                                                    }

                                                    success = false;
                                                    choiceDone = true;
                                                    break;

                                                default:
                                                    System.out.println("Invalid Choice");
                                            }
                                        } while (!choiceDone);

                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                } while (success);

                                break;
                            }

                            case 5: {
                                System.out.println("Portfolio");

                                if (user1.getPortfolio().getpositions().isEmpty()) {
                                    System.out.println("Portfolio is empty.");
                                } else {
                                    for (Position position : user1.getPortfolio().getpositions()) {
                                        Asset asset = position.getAsset();
                                        System.out.println(asset.getSymbol() + " -> "
                                                + asset.getName() + " -> " + asset.getPrice()+ " -> " +"Quantity :"+position.getQuantity());
                                    }

                                    success = true;

                                    do {
                                        String symbol = null;
                                        boolean invalid = false;
                                        do {
                                            try {
                                                System.out.print("Enter The Symbol Of Company: ");
                                                symbol = sc.next();
                                                user1.getPortfolio().containsAsset(market.getAsset(symbol));
                                                invalid = true;

                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                invalid = false;
                                            }
                                        } while (!invalid);

                                        System.out.print("How many assets do you want to sell: ");
                                        int quantity = sc.nextInt();

                                        try {
                                            Order order = new Order(
                                                    market.getAsset(symbol), "SELL",
                                                    quantity, user1.getNextOrderId());

                                            engine.placeOrder(order, user1);
                                            choiceDone = false;

                                            do {
                                                System.out.println("1. SELL");
                                                System.out.println("2. CANCEL");
                                                System.out.print("Enter the choice: ");

                                                int tradeChoice = sc.nextInt();

                                                switch (tradeChoice) {
                                                    case 1:
                                                        orderStatus = engine.processOrder(user1, order);

                                                        if (orderStatus == OrderStatus.EXECUTED) {
                                                            System.out.println("Order Executed");
                                                            success = false;
                                                            choiceDone = true;
                                                        }
                                                        break;

                                                    case 2:
                                                        orderStatus = engine.cancelOrder(user1, order);

                                                        if (orderStatus == OrderStatus.CANCELLED) {
                                                            System.out.println("Order Cancelled");
                                                        }

                                                        success = false;
                                                        choiceDone = true;
                                                        break;

                                                    default:
                                                        System.out.println("Invalid Choice");
                                                        break;
                                                }
                                            } while (!choiceDone);

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } while (success);
                                }
                                break;
                            }

                            case 6:
                                System.out.println("Order History");
                                for (Map.Entry<Integer, Order> entry : user1.getOrderHistory().entrySet()) {
                                    Order order = entry.getValue();
                                    System.out.println("=".repeat(40));
                                    System.out.println(entry.getKey() + " -> "
                                            + order.getOrderType() + " -> "
                                            + order.getAsset().getName() + " -> "
                                            + order.getQuantity() + " -> "
                                            + order.getOrderStatus());
                                    System.out.println("=".repeat(40));
                                }
                                break;

                            case 7:
                                System.out.println("Going back to main menu...");
                                break;

                            default:
                                System.out.println("Invalid Option");
                        }
                    } while (userChoice != 7);

                    break;
                }

                case 2: {
                    int adminChoice;

                    do {
                        System.out.println("=".repeat(40));
                        System.out.println("ADMIN MENU");
                        System.out.println("=".repeat(40));
                        System.out.println("1. Add Asset");
                        System.out.println("2. View Market");
                        System.out.println("3. Back");
                        System.out.print("Enter the choice: ");

                        adminChoice = sc.nextInt();

                        switch (adminChoice) {
                            case 1: {
                                int assetChoice;

                                do {
                                    System.out.println("1. Stock");
                                    System.out.println("2. Crypto");
                                    System.out.println("3. Back");
                                    System.out.print("Which Asset do you want to add: ");

                                    assetChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (assetChoice) {
                                        case 1:
                                            try {
                                                System.out.print("Enter the Symbol: ");
                                                String symbol = sc.nextLine();

                                                System.out.print("Enter the Company Name: ");
                                                String name = sc.nextLine();

                                                System.out.print("Enter The Price: ");
                                                double price = sc.nextDouble();

                                                System.out.print("Enter the Dividend: ");
                                                double dividend = sc.nextDouble();
                                                sc.nextLine();

                                                Asset asset = new Stock(symbol, name, price, dividend);
                                                market.addAsset(asset);
                                                System.out.println("Asset Added Successfully");
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                sc.nextLine();
                                            }
                                            break;

                                        case 2:
                                            try {
                                                System.out.print("Enter the Symbol: ");
                                                String symbol = sc.nextLine();

                                                System.out.print("Enter the Company Name: ");
                                                String name = sc.nextLine();

                                                System.out.print("Enter The Price: ");
                                                double price = sc.nextDouble();
                                                sc.nextLine();

                                                System.out.print("Enter the Network Name: ");
                                                String network = sc.nextLine();

                                                Asset asset = new Crypto(symbol, name, price, network);
                                                market.addAsset(asset);
                                                System.out.println("Asset Added Successfully");
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                sc.nextLine();
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Going back to Admin menu...");
                                            break;

                                        default:
                                            System.out.println("Invalid choice");
                                    }
                                } while (assetChoice != 3);

                                break;
                            }

                            case 2:
                                System.out.println("Market:");
                                for (Map.Entry<String, Asset> entry : market.getMarket().entrySet()) {
                                    Asset asset = entry.getValue();
                                    System.out.println(entry.getValue().getSymbol() + " -> "
                                            + asset.getName() + " -> " + asset.getPrice());
                                }
                                break;

                            case 3:
                                System.out.println("Going back to main menu...");
                                break;

                            default:
                                System.out.println("Invalid Option");
                        }
                    } while (adminChoice != 3);

                    break;
                }

                case 3:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid Option");
            }
        } while (choice != 3);

        Storage.save(user1, market, engine);
        System.out.println("Data saved successfully.");
    }
}
