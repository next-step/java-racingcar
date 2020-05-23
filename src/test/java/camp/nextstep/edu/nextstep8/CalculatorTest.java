package camp.nextstep.edu.nextstep8;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("지원하는 연산자인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "A:false"}, delimiter = ':')
    public void supportOperationTest(String operation, boolean expected) {

        // when
        boolean result = Calculator.isSupportedOperation(operation);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력한 수식이 유효한지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 + 3 + 4:true",
            "1 - - 2 - 3:false",
            "A + B - 3 / 2:false",
            "1 + 2 | 3 ( 4:false"
    }, delimiter = ':')
    public void expressionValidateTest(String expression, boolean expected) {
        // when
        boolean result = Calculator.isValidExpression(Arrays.asList(expression.split(StringUtils.SPACE)));

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 계산기가 바르게 동작하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "4 + 3 - 2 / 1:5",
            "10 * 20 / 5 + 20:60"
    }, delimiter = ':')
    public void calculationTest(String expression, int expected) {
        // when
        int result = Calculator.calculation(expression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열 계산할 때 잘못된 문자열을 입력했을 경우 예외 발생")
    @Test
    public void calculationExceptionTest() {
        // given
        String expression = "1 + 2 | 3 ( 4:false";

        assertThatThrownBy(()->{
            // when
            int result = Calculator.calculation(expression);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 식이 올바르지 않습니다 : " + expression);
    }
}