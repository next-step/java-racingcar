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

    @Test
    @DisplayName("입력문자열이 null인 경우를 확인한다")
    void checkInputStringNull() {
        // gien
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate(null);
                    // then
                }).withMessageMatching("Empty input string");
    }

    @Test
    @DisplayName("입력문자열이 빈 경우를 확인한다")
    void checkInputStringEmpty() {
        // gien
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate("");
                    // then
                }).withMessageMatching("Empty input string");
    }

    @Test
    @DisplayName("토큰의 전체개수가 3보다 작은경우를 확인한다")
    void checkNumberOfTokensIsLessThanThree() {
        // gien
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate("1 +");
                    // then
                }).withMessageMatching("Invalid token");
    }

    @Test
    @DisplayName("토큰의 전체개수가 홀수인지 확인한다")
    void checkNumberOfTokensOdd() {
        // gien
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate("1 + 1 +");
                    // then
                }).withMessageMatching("Invalid token");
    }

    @Test
    @DisplayName("지원하지 않는 연산자를 입력한 경우를 확인한다")
    void checkUnsupprotedOperator() {
        // gien
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate("1 % 1");
                    // then
                }).withMessageMatching("Unsupported operator");
    }

    @Test
    @DisplayName("숫자가 아닌 문자열을 입력한 경우를 확인한다")
    void checkNonNumericString() {
        // gien
        StringCalculator stringCalculator = new StringCalculator();

        assertThatExceptionOfType(NumberFormatException.class)
                // when
                .isThrownBy(() -> {
                    stringCalculator.calculate("a + 1");
                    // then
                }).withMessageMatching("For input string: \"a\"");
    }

    @Test
    @DisplayName("연산자가 여러개인 경우를 확인한다")
    void checkCompositeCase() {
        // given
        StringCalculator stringCalculator = new StringCalculator();
        // when
        String result =  stringCalculator.calculate("2 + 3 * 4 / 2");
        // then
        assertThat(result).isEqualTo("10");
    }
}
