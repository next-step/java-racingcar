package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void add() {
        int result = StringCalculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);

    }
    @Test
    public void sub(){
        int result = StringCalculator.calculate("5 - 3");
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void multi(){
        int result = StringCalculator.calculate("5 * 3");
        assertThat(result).isEqualTo(15);
    }
    @Test
    public void divide(){
        int result = StringCalculator.calculate("6 / 3");
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void totalCal(){
        int result = StringCalculator.calculate("2 + 3 * 4 / 2”");
        assertThat(result).isEqualTo(10);
    }
}