package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"3 + 5: 8", "3 + 5 + 6: 14"}, delimiter = ':')
    void 덧셈(String input, int expected) {
        assertThat(new Calculator(input).calculate()).isEqualTo(Number.of(expected));
    }

    @Test
    void 뺄셈() {
        assertThat(new Calculator("10 - 5 - 2").calculate()).isEqualTo(Number.of(3));
    }

    @Test
    void 곱셈() {
        assertThat(new Calculator("10 * 5 * 2 * 1").calculate()).isEqualTo(Number.of(100));
    }

    @Test
    void 나눗셈() {
        assertThat(new Calculator("10 / 5").calculate()).isEqualTo(Number.of(2));
    }

    @Test
    void 혼합() {
        assertThat(new Calculator("2 + 3 * 4 / 2").calculate()).isEqualTo(Number.of(10));
    }

    @DisplayName("나눗셈 결과가 정수가 아니면 예외 발생")
    @Test
    void 나눗셈_결과는정수() {
        assertThatThrownBy(() -> {
            new Calculator("5 / 10").calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과값은 정수만 허용");
    }

    @DisplayName("0으로 나누면 예외 발생")
    @Test
    void 나눗셈_0() {
        assertThatThrownBy(() -> {
            new Calculator("10 / 2 / 0").calculate();
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("by zero");
    }

    @DisplayName("입력값이 NULL 또는 빈 공백이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void 입력값_널또는공백(String input) {
        assertThatThrownBy(() -> {
            new Calculator(input).calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값이 없습니다");
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"3 ( 5", "3 + 5 = 1", "5 $ 1"})
    void 입력값_사칙연산기호(String input) {
        assertThatThrownBy(() -> {
            new Calculator(input).calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산자가 아닙니다.");
    }

    @DisplayName("입력값이 두 개면 계산 불가능")
    @ParameterizedTest
    @ValueSource(strings = {"3 5", "+ -", "3 +"})
    void 입력값_계산불가능(String input) {
        assertThatThrownBy(() -> {
            new Calculator(input).calculate();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("계산할 수 없습니다.");
    }

}
