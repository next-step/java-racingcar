package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    private final StringCalculator sut = new StringCalculator();

    @Test
    @DisplayName("덧셈")
    public void plus() {
        int result = sut.calculateAll("1 + 2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        int result = sut.calculateAll("3 - 1");

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        int result = sut.calculateAll("6 / 2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        int result = sut.calculateAll("2 * 4");

        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    public void exception1() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            sut.calculateAll("1 & 3");
        }).withMessageContaining("사칙연산 기호가 아닙니다");
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    @ValueSource(strings = {" "})
    @NullAndEmptySource
    public void exception2(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            sut.calculateAll(input);
        }).withMessageContaining("유효하지 않은 입력값");
    }
}