package App.model;
public abstract class Customer extends Account{
    private final Address address;
    private final Basket basket;

    public Customer(){
        basket = null;
        address = null;
    };
    public Customer(String log, String pas, AccountType typ) {
        super(log, pas, typ);
        address = null;
        basket = null;
    }
    public Customer(String log, String pas,String street, String postalCode, String city, AccountType typ){
        super(log, pas, typ);
        basket = null;
        address = new Address(street, postalCode, city);
    }
    public Address getAddress(){
        return this.address.getAddress();
    }

}


