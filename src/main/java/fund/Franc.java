package fund;

public class Franc extends Money{

    public Franc(int amount) {
        super(amount);
    }

    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public String currency() {
        return "CHF";
    }

}
