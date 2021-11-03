package step2;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private static final Calculator calculator = new Calculator();

    @DisplayName("null이나 공백을 입력하면 예외가 발생한다.")
    @ParameterizedTest(name = "{index}. expression: {arguments}")
    @NullAndEmptySource
    void calculate_blankInput_thrownException(String expression) throws Exception {
        //when
        ThrowingCallable calculate = () -> calculator.calculate(expression);

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(calculate)
                .withMessage("expression is required");
    }
    
    @DisplayName("다양한 연산 검증")
    @ParameterizedTest(name = "[{index}] {0} = {1}")
    @CsvSource(delimiter = '=', value = {
            "1 + 3 = 4",
            "2 * 3 / 3 = 2",
            "1 - 6 * 5 = -25"
    })
    void calculateTest(String expression, int expected) throws Exception {
        //when
        int result = calculator.calculate(expression);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
