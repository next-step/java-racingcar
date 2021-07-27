package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 덧셈(){
        //given
        String given = "2 + 3";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 뺄셈(){
        //given
        String given = "3 - 2";
        //when
        int result = Calculator.calculate(given);
        //then
        assertThat(result).isEqualTo(1);
    }
}
