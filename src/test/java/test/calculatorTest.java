package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.Calculator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class calculatorTest {

    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
//    @ValueSource(strings = {""})
    void inputValidCheckTest(String text) {
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Calculator calc = new Calculator();
                calc.calculator(text);
            }).isInstanceOf(IllegalArgumentException.class)
            .withMessageMatching("입력값이 null+.*")
            .withMessageMatching(".*빈 공백.*");
    }

    @DisplayName("덧셈 기호가 있으면 덧셈을 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3"})
    void addTest(String input) {
        Calculator calc = new Calculator();
        assertThat(calc.calculator(input)).isEqualTo(5);
    }

    @DisplayName("뺄셈 기호가 있으면 뺄셈을 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 - 3"})
    void substractTest(String input) {
        Calculator calc = new Calculator();
        assertThat(calc.calculator(input)).isEqualTo(-1);
    }

    @DisplayName("곱셈 기호가 있으면 곱셈을 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3"})
    void multipulyTest(String input) {
        Calculator calc = new Calculator();
        assertThat(calc.calculator(input)).isEqualTo(6);
    }

    @DisplayName("나눗셈 기호가 있으면 나눗셈을 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 / 3"})
    void divideTest(String input) {
        Calculator calc = new Calculator();
        assertThat(calc.calculator(input)).isEqualTo(0);
    }

    @DisplayName("사칙연산 기호가 모두 있으면 사칙연산을 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void calculatorTest(String input) {
        Calculator calc = new Calculator();
        assertThat(calc.calculator(input)).isEqualTo(10);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(strings = {"2 ++ 3 * 4 / 2"})
    void inputOperandCheckTest(String input) {
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Calculator calc = new Calculator();
                calc.calculator(input);
            }).isInstanceOf(IllegalArgumentException.class)
            .withMessageMatching("사칙연산+.*");
    }
}