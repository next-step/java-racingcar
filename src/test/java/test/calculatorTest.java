package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.Calculator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class calculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3", "10 + 8"})
    void addTest(String input) {
        Calculator calc = new Calculator();
        calc.calulator(input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"2 - 3", "10 - 8"})
    void substractTest(String input) {
        Calculator calc = new Calculator();
        calc.calulator(input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"2 * 3", "10 * 8"})
    void multipulyTest(String input) {
        Calculator calc = new Calculator();
        calc.calulator(input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"2 / 3", "10 / 8", "6 / 3"})
    void divideTest(String input) {
        Calculator calc = new Calculator();
        calc.calulator(input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
        //@ValueSource(strings = {"2 + 3 * 4 / 2", "3 * 10 - 5 / 5"})
    void calculatorTest(String input) {
        Calculator calc = new Calculator();
        calc.calulator(input);
    }

    @Test
    void inputValidCheckTest() {
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Calculator calc = new Calculator();
                calc.calulator("");
            }).withMessageMatching("입력값이 null+.*")
            .withMessageMatching(".*빈 공백.*");

    }
    @Test
    void inputOperandCheckTest() {
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                Calculator calc = new Calculator();
                calc.calulator("2 ++ 3 * 4 / 2");
            }).withMessageMatching("사칙연산+.*");
    }
}