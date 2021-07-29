package stringCaculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CaculatorTest {

    @Test
    @DisplayName("덧셈 계산을 하는지 테스트")
    void sum() {
        int result = Calculator.calculate("3 + 5");
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 계산을 하는지 테스트")
    void subtract() {
        int result = Calculator.calculate("10 - 5");
        assertThat(result).isEqualTo(5);

        result = Calculator.calculate("3 - 5");
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("나눗셈 계산을 하는지 테스트")
    void divide() {
        int result = Calculator.calculate("10 / 5");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 계산을 하는지 테스트")
    void multiple() {
        int result = Calculator.calculate("10 * 5");
        assertThat(result).isEqualTo(50);
    }

    @Test
    @DisplayName("여러 연산자가 혼합되어 있을 때 계산을 하는지 테스트")
    void complicatedCal() {
        int result = Calculator.calculate("10 * 5 + 5 / 5 - 3");
        assertThat(result).isEqualTo(8);

        result = Calculator.calculate("2 - 3 * 10 - 7 + 5");
        assertThat(result).isEqualTo(-12);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "3 $ 5", "4 + 5 & 1"})
    @DisplayName("입력값이 이상할 때 예외를 던지는지 테스트")
    void invalidInput(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                Calculator.calculate(value);
        });
    }
}
