package fund;

public abstract class Money {
    protected int amount;
    protected String currency;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount  && getClass().equals(money.getClass());
    }

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    public abstract Money times(int amount);

    public String currency() {
        return currency;
    }
}
