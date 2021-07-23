package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    void add(){
        int result = StringCalculator.calc("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void sub(){
        int result = StringCalculator.calc("3 - 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    void mul(){
        int result = StringCalculator.calc("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void div(){
        int result = StringCalculator.calc("6 / 2");
        assertThat(result).isEqualTo(3);
    }
}
