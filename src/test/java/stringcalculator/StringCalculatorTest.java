package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @Test
    @DisplayName("더하기 기능을 확인한다")
    void checkAddition() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        String result = stringCalculator.calculate("1 + 1");
        // then
        assertThat(result).isEqualTo("2");
    }

    @Test
    @DisplayName("뻬기 기능을 확인한다")
    void checkSubtraction() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        String result = stringCalculator.calculate("10 - 5");
        // then
        assertThat(result).isEqualTo("5");
    }

    @Test
    @DisplayName("곱하기 기능을 확인한다")
    void checkMultiplication() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        String result = stringCalculator.calculate("10 * 5");
        // then
        assertThat(result).isEqualTo("50");
    }

    @Test
    @DisplayName("나누기 기능을 확인한다")
    void checkDivision() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        String result = stringCalculator.calculate("10 / 5");
        // then
        assertThat(result).isEqualTo("2");
    }

    @Test
    @DisplayName("0으로 나누었을때 예외를 확인한다")
    void checkExceptionWhenDividingByZero() {
        // given
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate("0 / 5");
                    // then
                }).withMessageMatching("Can not divide by zero");
    }
}
