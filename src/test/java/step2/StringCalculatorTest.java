package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    @DisplayName("입력받은 식에 대해서 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 * 1 + 2 / 3 - 1:0"}, delimiter = ':')
    void calculate(String expression, Integer expectedResult) {
        assertThat(StringCalculator.calculate(expression)).isEqualTo(expectedResult);
    }

    @DisplayName("연산자가 올바르게 작성되지 않은 식에서 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"2 + + 3 * 4", "1 + 3 - * 5"})
    void throwIllegalArgumentExceptionWhenGivenNonValidOperatorCount(String expression) {
        assertThrows(IllegalArgumentException.class,()->StringCalculator.calculate(expression));
    }

    @DisplayName("숫자 연산자 연산자 와 같이 올바른 순서의 식이 아닐 때 IllegalArgumentException 발생")
    @Test
    void 끄기_전에_생각난_테스트코드() {
        String given = "2 2 + + 2";
        assertThrows(IllegalArgumentException.class,()->StringCalculator.calculate(given));
    }

}
