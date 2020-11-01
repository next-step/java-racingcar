package step2;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    private final static Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 테스트")
    public void add () {
        assertThat(calculator.addition(3, 2)).isEqualTo(5);
    }

    @Test
    @DisplayName("빼기 테스트")
    public void sub () {
        assertThat(calculator.subtraction(3, 2)).isEqualTo(1);
    }
    @Test
    @DisplayName("곱하기 테스트")
    public void mul () {
        assertThat(calculator.multiplication(3, 2)).isEqualTo(6);
    }
    @Test
    @DisplayName("나누기 테스트")
    public void div () {
        assertThat(calculator.division(4, 2)).isEqualTo(2);
    }

}
