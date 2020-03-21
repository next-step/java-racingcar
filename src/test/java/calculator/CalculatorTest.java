package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    String formula            = "";
    String[] result           = null;
    String[] operationSymbols = null;
    Calculator calc           = null;
    double resultVal          = 0;


    @BeforeEach
    void setUp() {
        formula          = "1 + 2 * 4 / 3";
        result           = formula.split(" ");
        operationSymbols = new String[]{"+", "-", "*", "/"};
        resultVal        = 0;
        calc = new Calculator(formula, operationSymbols);
    }

    @DisplayName("계산 테스트")
    @Test
    void calculatorTest() {
        assertThat(calc.calculate(result)).isEqualTo(4.0);
    }

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @ValueSource(doubles = {3})
    void addditionTest( double inputVal) {
        assertThat(calc.adddition(inputVal)).isEqualTo(3.0);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @ValueSource(doubles = {3})
    void subtractionTest( double inputVal) {
        assertThat(calc.subtraction(inputVal)).isEqualTo(-3.0);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @ValueSource(doubles = {3})
    void multiplicationTest( double inputVal) {
        assertThat(calc.multiplication(inputVal)).isEqualTo(0);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @ValueSource(doubles = {3})
    void addTest( double inputVal) {
        assertThat(calc.division(inputVal)).isEqualTo(0);
    }

    @DisplayName("연산기호 정합성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"+","-","*","X"})
    void operatorCheckTest( String inputVal) {
        assertThat(calc.operatorCheck(inputVal)).isEqualTo(true);
    }

    @DisplayName("빈값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1","3","","8"})
    void isNullOrEmptyTest( String inputVal) {
        assertThat(calc.isNullOrEmpty(inputVal)).isEqualTo(false);
    }

}
