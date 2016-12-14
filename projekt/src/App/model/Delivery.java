package App.model;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by janusz on 12.12.16.
 */
public class Delivery {
    private LocalDate date;
    private LocalTime time;
    private Order order;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Order getOrder() {
        return order;
    }

    public Delivery(LocalDate date, LocalTime time, Order order){
        this.date = date;
        this.time = time;
        this.order = order;
    }
}
