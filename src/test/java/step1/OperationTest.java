package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("문자열계산기 동작 테스트")
public class OperationTest {

    @Test
    @DisplayName("정상적인 문자열 연산 테스트")
    void normal_input_string_test() {

        CalculatorApplication app = new CalculatorApplication();
        assertAll(
                () -> assertThat(app.runCalculatorApplication("1 + 2")).isEqualTo("3"),
                () -> assertThat(app.runCalculatorApplication("1 + 2 * 3")).isEqualTo("9"),
                () -> assertThat(app.runCalculatorApplication("1 + 2 * 3 / 4")).isEqualTo("2"),
                () -> assertThat(app.runCalculatorApplication("1 + 2 * 3 / 4 / 5")).isEqualTo("0"),
                () -> assertThat(app.runCalculatorApplication("1 + 2 * 3 / 4 / 5 - 6")).isEqualTo("-6"),
                () -> assertThat(app.runCalculatorApplication("1 + 2 * 3 / 4 / 5 - 6 + 7")).isEqualTo("1"),
                () -> assertThat(app.runCalculatorApplication("1 + 2 * 3 / 4 / 5 - 6 + 7 * 8")).isEqualTo("8")
        );
    }
}
