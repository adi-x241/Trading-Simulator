import java.time.LocalDateTime;
class Transaction {
    private  User user;
    private  Order order;
    private  LocalDateTime timeStamp ;

    Transaction( User user,Order order){
        this.user=user;
        this.order=order;
        this.timeStamp =LocalDateTime.now();
    }

    
}