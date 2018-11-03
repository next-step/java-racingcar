package calculator;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    @Test
    public void add() {
       int result = new Plus().calc(3, 5);
       assertThat(result).isEqualTo(8);
    }

    @Test
    public void minus() {
        int result = new Minus().calc(5, 3);
        assertThat(result).isEqualTo(2);
        assertThat(result).isNotEqualTo(0);
    }
}