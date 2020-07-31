package camp.nextstep.edu.rebellion.calc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @DisplayName("입력한 수식 대로 올바른 결과가 나오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 + 3 + 4:10",
            "10 + 9 - 8 * 7 / 6:12",
            "1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10:55"
    }, delimiter = ':')
    public void calcTest(String expression, int expected) {
        // when
        int result = Calculator.calc(expression);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("입력한 수식이 올바르지 않을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "1+2+3+4",
            "1 + 2 + +",
            "1    + 2 3"
    })
    public void calcThrownExceptionTest(String expression) {
        // when & then
        assertThatThrownBy(() -> Calculator.calc(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
