package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    String formula            = "";
    String[] result           = null;
    String[] operationSymbols = null;
    Calculator calculator;
    StringCalculator stringCalculator;
    double resultVal          = 0;



    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        stringCalculator = new StringCalculator();
    }


    @DisplayName("덧셈")
    @ParameterizedTest
    @CsvSource(value = {"5,10,15","1111,2222,3333"})
    void additionTest(double a, double b, int result) {
        assertThat(calculator.adddition(a,b)).isEqualTo(result);
    }

    @DisplayName("뺄셈")
    @ParameterizedTest
    @CsvSource(value = {"5,10,-5","1111,2222,-1111"})
    void subtractionTest(double a, double b, int result) {
        assertThat(calculator.subtraction(a,b)).isEqualTo(result);
    }

    @DisplayName("곱셈")
    @ParameterizedTest
    @CsvSource(value = {"5,10,50","1111,2222,2468642"})
    void multiplicationTest(double a, double b, int result) {
        assertThat(calculator.multiplication(a,b)).isEqualTo(result);
    }

    @DisplayName("나눗셈")
    @ParameterizedTest
    @CsvSource(value = {"10,5,2","72,9,8"})
    void divisionTest(double a, double b, int result) {
        assertThat(calculator.division(a,b)).isEqualTo(result);
    }

    @DisplayName("StringCalculator 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10" , "6 - 4 * 3 / 2, 3"})
    void stringCalculateTest(String formula, double result) {
        assertThat(stringCalculator.calculate(formula)).isEqualTo(result);
    }

    @DisplayName("사칙연산 기호 정합성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 10 x 5"})
    void symbolValidTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input));
    }

    @DisplayName("입력값 null,공백 체크")
    @ParameterizedTest
    @NullAndEmptySource
    void stringCalculateTestByNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate(input));
    }


}
