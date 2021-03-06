package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("문자열로 들어온 덧셈 연산식을 계산하는 테스트")
    @ParameterizedTest(name = "연산식 : {0} = {1}")
    @CsvSource(value = {"2 + 3:5", "-1 + 1:0", "10 + -3:7", "10 + 5:15", "0 + 0:0"}, delimiter = ':')
    void plusTest(String expression, int expect){
        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("문자열로 들어온 뺄셈 연산식을 계산하는 테스트")
    @ParameterizedTest(name = "연산식 : {0} = {1}")
    @CsvSource(value = {"2 - 3:-1", "-1 - -1:0", "0 - 0:0", "10 - 7:3", "-0 - -0:0"}, delimiter = ':')
    void subtractTest(String expression, int expect){

        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(expect).isEqualTo(result);
    }

    @DisplayName("문자열로 들어온 곱셈 연산식을 계산하는 테스트")
    @ParameterizedTest(name = "연산식 : {0} = {1}")
    @CsvSource(value = {"2 * 3:6", "-1 * -1:1", "0 * 0:0", "32 * 7:224", "-0 * -0:0"}, delimiter = ':')
    void multiplyTest(String expression, int expect){

        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("문자열로 들어온 나눗셈 연산식을 계산하는 테스트")
    @ParameterizedTest(name = "연산식 : {0} = {1}")
    @CsvSource(value = {"10 / 5:2", "100 / 10:10", "10 / -10:-1", "32 / 4:8", "-1 / -1:1"}, delimiter = ':')
    void divideTest(String expression, int expect){

        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("문자열로 들어온 연산식을 계산하는 테스트")
    @ParameterizedTest(name = "연산식 : {0} = {1}")
    @CsvSource(value = {"10 / 5 * 2 + 5 - 1:8", "12 + 10 - 2 / 4 * 10:50",
            "-1 - -10 * 5 + 5 / 10:5", "0 - 0 + 0 * 0 / 1:0"}, delimiter = ':')
    void calculatorTest(String expression, int expect){
        // when
        int result = calculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("공백을 넣었을 때 IllegalArgumentException() 을 발생시키는지 확인하는 테스트")
    @Test
    void checkBlankExpression(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(" ");
        });
    }

    @DisplayName("null 넣었을 때 IllegalArgumentException() 을 발생시키는지 확인하는 테스트")
    @Test
    void checkNullExpression(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate(null);
        });
    }

    @DisplayName("공백이 2개 이상인 문자열을 넣었을 때 IllegalArgumentException() 을 발생시키는지 확인하는 테스트")
    @Test
    void checkConsecutiveBlanksExpression(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("  ");
        });
    }

}