package fund;

public class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        Money money = (Money) o;
        return amount == money.amount;
    }
}
