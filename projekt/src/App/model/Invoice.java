package App.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by janusz on 12.12.16.
 */
public class Invoice {
    private static Integer ID = 0;
    private Integer invoiceID;
    private LocalDate date;
    private List<Position> positions;
    private Customer customer;

    public Invoice(Customer customer) {
        this.customer = customer;
        date = LocalDate.now();
        invoiceID = ID;
        ID += 1;
    }
}
