
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

class Storage {

    public static void save(User user, Market market, TradingEngine engine)
            throws IOException {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("simulator.dat"))) {

            out.writeObject(user);
            out.writeObject(market);
            out.writeObject(engine);

        }
    }

    public static Object[] load()
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("simulator.dat"))) {

            User user = (User) in.readObject();
            Market market = (Market) in.readObject();
            TradingEngine engine = (TradingEngine) in.readObject();

            return new Object[]{user, market, engine};
        }
    }
}
