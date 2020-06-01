package study.step2;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.Calculator;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void Calculator() {
        calculator = new Calculator();
    }

    @DisplayName("정상 계산식 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5 * 4 / 2:10", "10 + 2 * 3 / 4:9"}, delimiter = ':')
    void normalCalculation(String inputExpression, double expectedResult){
        double result = calculator.calculate(inputExpression);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("비정상 계산식 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5 * 4 / 2:10", "10 + 2 * 3 / 4:9"}, delimiter = ':')
    void abnormalCalculation(String inputExpression, double expectedResult){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(inputExpression);
        });
    }

    @DisplayName("입력값 null or 공백 테스트")
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void IsEmptyOrNullString(String inputExpression){
        assertThat(calculator.inputExpressionIsNotNull(inputExpression)).isEqualTo(true);
    }

    @DisplayName("정상 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"+:5", "*:6", "-:1", "/:1.5"}, delimiter = ':')
    void normalOperator(String inputExpression, double expectedResult){
        double operand1 = 3, operand2 = 2;
        assertThat(calculator.getOperation(inputExpression, operand1, operand2)).isEqualTo(expectedResult);
    }

    @DisplayName("정상 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"@:5", "(:6", "^:1", "$:1.5"}, delimiter = ':')
    void abnormalOperator(String inputExpression, double expectedResult){
        double operand1 = 3, operand2 = 2;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.getOperation(inputExpression, operand1, operand2);
        });
    }

}
