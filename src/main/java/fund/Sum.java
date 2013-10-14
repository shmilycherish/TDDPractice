package fund;

public class Sum implements Expression {
    public static Money augend ;
    public static Money addend;

    public Sum(Money augend, Money addend) {
       this.augend = augend;
       this.addend = addend;
    }


    public static Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}
