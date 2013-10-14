package fund;

public class Bank {
    public Money reduce(Expression source, String to) {
        Sum sum = (Sum)source;
        return Sum.reduce(to);
    }
}
