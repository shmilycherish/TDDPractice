import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiFundTest {
    @Test
    public void multiplicationTest() throws Exception {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }
}
