package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @Test
    @DisplayName("null 입력")
    void inputNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.of().calculate(null));
    }

    @Test
    @DisplayName("공백 입력")
    void inputBlank() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.of().calculate(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "1 = 2",
        "1 & 2",
        "1 + 3 # 1",
        "1 ( 3 * 3"
    })
    @DisplayName("잘못된 연산 기호")
    void invalidOperator(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.of().calculate(input));
    }

    @Test
    @DisplayName("연산 기호만 있는 경우")
    void invalidInputOnlyOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.of().calculate("+"));
    }

    @Test
    @DisplayName("숫자만 있는 경우")
    void invalidInputOnlyNumber() {
        assertThat(Calculator.of().calculate("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("올바른 입력 값")
    void ok() {
        assertThat(Calculator.of().calculate("2 + 3 * 4 / 2 - 1")).isEqualTo(9);
    }

    @Test
    @DisplayName("올바른 입력 값2 (마이너스 값 포함)")
    void okMinusNumber() {
        assertThat(Calculator.of().calculate("-10 + 2 + 3")).isEqualTo(-5);
    }

}