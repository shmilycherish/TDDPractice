package fund;

public class Franc extends Money{

    public Franc(int amount) {
        super(amount);
        currency = "CHF";
    }

    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
