package stage2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalculatorTest {

    private Calculator c;

    @BeforeAll
    public void setup() {
        c = new Calculator();
    }

    @Test
    @DisplayName("통합 기능 테스트")
    void calculator() {
        String input = "2 + 3 * 4 / 2";
        Integer expectedValue = 10;

        Integer result = c.calculate(input);

        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 Null 테스트")
    void calculator_null_test() {
        String input = null;

        Throwable throwable = catchThrowable(() -> c.calculate(input));

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값 공백 테스트")
    @ValueSource(strings = {" ", ""})
    void calculator_blank_test(String input) {
        Throwable throwable = catchThrowable(() -> c.calculate(input));

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 테스트 - 덧셈")
    void calculator_add_test() {
        String input = "1 + 2 + 3 + 4 + 5";
        Integer expectedValue = 15;

        Integer result = c.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 테스트 - 뺄셈")
    void calculator_minus_test() {
        String input = "50 - 10 - 5 - 1";
        Integer expectedValue = 34;

        Integer result = c.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 테스트 - 곱셈")
    void calculator_multi_test() {
        String input = "2 * 2 * 2 * 2";
        Integer expectedValue = 16;

        Integer result = c.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("사칙연산 테스트 - 나눗셈")
    void calculator_divide_test() {
        String input = "50 / 5 / 5 / 2";
        Integer expectedValue = 1;

        Integer result = c.calculate(input);

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("잘못된 연산자 넣었을 경우 테스트")
    void calculator_invalid_operation_test() {
        String input = "1 ? 2";

        Throwable throwable = catchThrowable(() -> c.calculate(input));

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
