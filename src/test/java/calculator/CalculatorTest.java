package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("calculate 함수 정상적인 케이스")
    void calculateSuccess() {
        assertThat(calculator.calculate("2 + 3"))
                .isEqualTo(5);
        assertThat(calculator.calculate("2 + 3 * 4"))
                .isEqualTo(20);
        assertThat(calculator.calculate("2 + 3 * 4 / 2"))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("calculate 함수 실패하는 케이스")
    void calculateFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(null);
                }).withMessageMatching("입력 값이 null");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("");
                }).withMessageMatching("입력 값이 빈 공백 문자");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2");
                }).withMessageMatching("array 의 길이는 3이상이어야 한다.");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2 + 3 *");
                }).withMessageMatching("array 의 길이는 홀수여야 한다.");
    }
}