package fund;

public class Franc extends Money{

    private String currency;

    public Franc(int amount) {
        super(amount);
        currency = "CHF";
    }

    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public String currency() {
        return currency;
    }

}
