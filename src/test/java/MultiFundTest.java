import fund.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MultiFundTest {
    @Test
    public void multiplicationTest() throws Exception {
        Money five = Money.dollar(5);
        assertTrue(Money.dollar(10).equals(five.times(2)));
        assertTrue(Money.dollar(15).equals(five.times(3)));
    }

    @Test
    public void equalityTest() throws Exception {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void FrancMultiplicationTest() throws Exception {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void currencyTest() throws Exception {
        assertTrue("USD".equals(Money.dollar(1).currency()));
        assertTrue("CHF".equals(Money.franc(1).currency()));
    }

    @Test
    public void differentTest() throws Exception {
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }

    @Test
    public void simpleAdditionTest() throws Exception {

        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10),reduced);
    }

    @Test
    public void plusReturnSumTest() throws Exception {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void reduceSumTest() throws Exception {
        Expression sum = new Sum(Money.dollar(1), Money.dollar(2));
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(3),reduced);
    }

    @Test
    public void reduceMoneyTest() throws Exception {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void reduceDifferentCurrencyTest() throws Exception {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void mixedAdditionTest() throws Exception {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveDollars.plus(tenFranc), "USD");
        assertEquals(Money.dollar(10), result);
    }
}

