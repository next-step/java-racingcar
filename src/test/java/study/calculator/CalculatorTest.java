package study.calculator;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CalculatorTest {
//    테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
//    덧셈
//    뺄셈
//    곱셈
//    나눗셈
//    입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
//    사칙연산 기호가 아닌 경우 IllegalArgumentException throw
//    사칙 연산을 모두 포함하는 기능 구현
//    공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
//    반복적인 패턴을 찾아 반복문으로 구현한다.

    Calculator calculator = new Calculator();
    private String reqString = "2 + 3 * 4 / 2";

    @DisplayName("덧셈")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1 = 2", "3 + 1 = 4", "0 + 0 = 0"}, delimiter = '=')
    void 덧셈(String reqString, Integer expected) {
        assertThat(calculator.calculate(reqString)).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest
    @CsvSource(value = {"1 - 1 = 0", "3 - 1 = 2", "0 - 0 = 0"}, delimiter = '=')
    void 뺄셈(String reqString, Integer expected) {
        assertThat(calculator.calculate(reqString)).isEqualTo(expected);
    }

    @DisplayName("곱셈")
    @ParameterizedTest
    @CsvSource(value = {"1 * 1 = 1", "3 * 1 = 3", "0 * 0 = 0", "3 * 0 = 0"}, delimiter = '=')
    void 곱셈(String reqString, Integer expected) {
        assertThat(calculator.calculate(reqString)).isEqualTo(expected);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest
    @CsvSource(value = {"1 / 1 = 1", "3 / 1 = 3", "0 / 0 = 0", "12 / 4 = 3"}, delimiter = '=')
    void 나눗셈(String reqString, Integer expected) {
        assertThat(calculator.calculate(reqString)).isEqualTo(expected);
    }

    @DisplayName("입력값null")
    @Test
    void 입력값null() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(null);
                });
    }

    @DisplayName("입력값blank")
    @Test
    void 입력값blank() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("");
                });
    }

    @DisplayName("사칙연산기호가아닌경우")
    @Test
    void 사칙연산기호가아닌경우() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("%");
                });
    }

    @DisplayName("사칙연산")
    @Test
    void 사칙연산() {
        assertThat(calculator.calculate(reqString)).isEqualTo(10);
    }

}
