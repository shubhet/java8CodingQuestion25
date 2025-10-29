package custmoerSpends;

public class CustomerSpends {

    private String customer;
    private double amount;

    public CustomerSpends(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}

