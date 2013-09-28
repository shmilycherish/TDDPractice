package fund;

public class Dollar extends Money {

    public Dollar(int amount) {
        super(amount);
        currency = "USD";
    }

    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
