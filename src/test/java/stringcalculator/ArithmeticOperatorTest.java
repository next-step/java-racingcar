package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ArithmeticOperatorTest {

    @Test
    @DisplayName("더하기 기능을 확인한다")
    void checkAddition() {
        // given
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        // when
        int result = arithmeticOperator.operate(ArithmeticOperator.Type.ADDITION, 1, 1);
        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("뻬기 기능을 확인한다")
    void checkSubtraction() {
        // given
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        // when
        int result = arithmeticOperator.operate(ArithmeticOperator.Type.SUBTRACTION, 2, 1);
        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 기능을 확인한다")
    void checkMultiplication() {
        // given
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        // when
        int result = arithmeticOperator.operate(ArithmeticOperator.Type.MULTIPLICATION, 3, 3);
        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    @DisplayName("나누기 기능을 확인한다")
    void checkDivision() {
        // given
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();
        // when
        int result = arithmeticOperator.operate(ArithmeticOperator.Type.DIVISION, 4, 2);
        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("0으로 나누었을때 예외를 확인한다")
    void checkExceptionWhenDividingByZero() {
        // given
        ArithmeticOperator arithmeticOperator = new ArithmeticOperator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    arithmeticOperator.operate(ArithmeticOperator.Type.DIVISION, 0, 2);
                // then
                }).withMessageMatching("Can not divide by zero");
    }
}
