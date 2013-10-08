package fund;

public class Money {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount  && currency().equals(money.currency());
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public  Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    public Money plus(Money dollar) {
        return new Money(amount+dollar.amount, currency);
    }
}
