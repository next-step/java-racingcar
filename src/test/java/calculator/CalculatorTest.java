package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("빈 값이 들어오면 0을 반환합니다.")
    void returnZero() {
        // given
        String input = "";
        // when
        int result = calculator.sumAll(input);
        // then
        assertThat(result).isZero();
    }

    @ParameterizedTest(name = "쉼표나 콜론을 구분자로 가지는 문자열은 각 숫자의 합을 반환합니다.")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3", "1,2:3"})
    void sumAll(String input) {
        // given
        // when
        int result = calculator.sumAll(input);
        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 이외의 값이 들어가는 경우 RuntimeException 예외를 던집니다.")
    void existString() {
        // given
        String input = "1,str,2";
        // when
        // then
        assertThatThrownBy(() -> calculator.sumAll(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 이외의 값이 존재합니다.");
    }

    @Test
    @DisplayName("음수를 전달하는 경우 RuntimeException 예외를 던집니다.")
    void existNegativeNumber() {
        // given
        String input = "1,-1:1";
        // when
        // then
        assertThatThrownBy(() -> calculator.sumAll(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수 값이 존재합니다.");
    }
}