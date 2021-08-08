package stage2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
        int expectedValue = 10;

        int result = c.calculate(input);

        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    @DisplayName("입력값 Null 테스트")
    void calculatorNullTest() {
        String input = null;

        Throwable throwable = catchThrowable(() -> c.calculate(input));

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값 공백 테스트")
    @ValueSource(strings = {" ", ""})
    void calculatorBlankTest(String input) {
        Throwable throwable = catchThrowable(() -> c.calculate(input));

        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
