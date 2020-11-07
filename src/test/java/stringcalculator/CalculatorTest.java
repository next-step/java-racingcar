package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-03.
 */
class CalculatorTest {

    @ParameterizedTest
    @DisplayName("계산 실제로 되는가?")
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void 입력값_테스트_0(String input) {
        Calculator cal = new Calculator(input);
        assertThat(cal.calculate()).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("입력값이 null")
    @NullSource
    public void 입력값_테스트_1(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값이 빈칸")
    @ValueSource(strings = {""})
    public void 입력값_테스트_2(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닐 때")
    @ValueSource(strings = {"a + 1"})
    public void 입력값_테스트_3(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("주어진 기호가 아닐 때")
    @ValueSource(strings = {"2 . 4"})
    public void 입력값_테스트_4(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력값 마무리가 안되었을 때")
    @ValueSource(strings = {"2 + 4 -"})
    public void 입력값_테스트_5(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("나눗셈 오류")
    @ValueSource(strings = {"2 + 4 / 0"})
    public void 입력값_테스트_6(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(ArithmeticException.class);
    }


    // 입력 식 띄어쓰기 아닐 때
    @ParameterizedTest
    @DisplayName("부호와 숫자 간 띄어쓰기 없을 때")
    @ValueSource(strings = {"2 +4", "2+ 4", "2 + 4- 4,"})
    public void 입력값_테스트_7(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("부호와 숫자 간 한 칸 띄어쓰기 필요");
    }

    // 나눗셈 => 정수 반환 안 될 때
    @ParameterizedTest
    @DisplayName("나눗셈: 정수 반환 안 될 때")
    @ValueSource(strings = {"2 / 3"})
    public void 입력값_테스트_8(String input) {
        assertThatThrownBy(() -> new Calculator(input).calculate())
                .isInstanceOf(ArithmeticException.class)
                .withFailMessage("나눗셈은 정수로 나누어 떨어져야 합니다.");
    }
}