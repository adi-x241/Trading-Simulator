import java.time.LocalDateTime;
import java.io.Serializable;
class Transaction implements  Serializable{
    private  User user;
    private  Order order;
    private  LocalDateTime timeStamp ;

    Transaction( User user,Order order){
        this.user=user;
        this.order=order;
        this.timeStamp =LocalDateTime.now();
    }

    
}