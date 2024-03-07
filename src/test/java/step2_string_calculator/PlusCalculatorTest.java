package step2_string_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlusCalculatorTest {
    @DisplayName("null일 경우 0을 반환한다.")
    @Test
    void checkNullInput() {
        assertThat(PlusCalculator.splitAndSum(null)).isEqualTo(0);

    }

    @DisplayName("빈 문자열일 경우 0을 반환한다.")
    @Test
    void checkEmptyInput() {
        assertThat(PlusCalculator.splitAndSum("")).isEqualTo(0);
    }

    @DisplayName(" , : 구분자에 대해 덧셈 연산을 수행한다.")
    @Test
    void plusCalculation() {
        assertThat(PlusCalculator.splitAndSum("1,2,3")).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자가 입력되었을 경우 구분자로 사용한다.")
    @Test
    void customParser() {
        assertThat(PlusCalculator.splitAndSum("//!\n1!2!3")).isEqualTo(6);
    }

    @DisplayName("음수가 입력되었을 경우 RuntimeException을 반환한다.")
    @Test
    void exceptionMinusParser() {
        assertThatThrownBy(() -> {
            PlusCalculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("잘못된 입력이 왔을 경우 exception을 발생시킨다")
    @Test
    void exceptionParser() {
        assertThatThrownBy(() -> {
            PlusCalculator.splitAndSum("1,2,=3");
        }).isInstanceOf(NumberFormatException.class);
    }
}
