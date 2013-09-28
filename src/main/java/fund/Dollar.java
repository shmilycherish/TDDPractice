package fund;

public class Dollar extends Money {

    private String currency;

    public Dollar(int amount) {
        super(amount);
        currency = "USD";
    }

    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public String currency() {
        return currency;
    }

}
