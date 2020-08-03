package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import resource.StringResources;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void 널_문자열() {
        illegalArgumentException(null, StringResources.ERR_INCORRECT_EQUATION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void 빈_문자열(String equation) {
        illegalArgumentException(equation, StringResources.ERR_INCORRECT_EQUATION);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 +", "1 / 2 -", "1 - 3 * 5 +"})
    public void 잘못된_식(String equation) {
        illegalArgumentException(equation, StringResources.ERR_INCORRECT_EQUATION);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "1 + 2:3", "3 - 1 * 3:6", "1 + 2 - 3 * 4 / 5:0"}, delimiter = ':')
    public void 정상_결과_도출(String equation, int result) {

        Calculator calculator = new Calculator(equation);
        assertThat(calculator.calculate()).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 / 0", "2 + 5 * 3 / 0"})
    public void 나누기_0(String equation) {

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> (new Calculator(equation)).calculate())
                .withMessage(StringResources.ERR_DIVIDED_BY_ZERO);
    }

    @ParameterizedTest
    @CsvSource(value = {"+:3", "-:1", "*:2", "/:2"}, delimiter = ':')
    public void 매핑_성공(char op, int result) {

        Operator operator = OperatorMapper.getOperator(op);
        assertThat(operator.calculate(2, 1)).isEqualTo(result);
    }

    @Test
    public void 매핑_실패() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> OperatorMapper.getOperator('('))
                .withMessage(StringResources.ERR_INCORRECT_OPERATOR);
    }

    private void illegalArgumentException(String equation, String resource) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator(equation))
                .withMessage(resource);
    }
}
