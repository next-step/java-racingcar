package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @DisplayName("사용자가 입력한 입력 값이 null이 오거나 빈 공백 문자일 경우")
    @Test
    void check_user_input_value() {
        stringCalculator = new StringCalculator("5 + 3");
        assertThatThrownBy(() -> {
            stringCalculator.checkInputValue(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("사칙연산 기호가 아닌 경우")
    @Test
    void non_operator_test() {
        stringCalculator = new StringCalculator("5 a 3");
        assertThatThrownBy(() -> {
            stringCalculator.returnResult(stringCalculator.inputDatas);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산 기호가 아닙니다.");
    }

    @DisplayName("숫자인지 연산자인지 구분하기 위한 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"5", "+", "3"})
    void isDigit_test(String data) {
        stringCalculator = new StringCalculator(data);
        assertThat(stringCalculator.isDigit(data));
    }

    @DisplayName("덧셈 테스트")
    @Test
    void addition_test() {

        stringCalculator = new StringCalculator("5 + 3");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(8);

    }

    @DisplayName("뺄셈 테스트")
    @Test
    void substraction_test() {

        stringCalculator = new StringCalculator("5 - 3");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(2);

    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplication_test() {
        stringCalculator = new StringCalculator("5 * 3");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(15);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void division_test() {
        stringCalculator = new StringCalculator("10 / 2");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(5);

    }

    @DisplayName("조금은 복잡한 연산 테스트")
    @Test
    void little_complicated_calculate_test() {
        stringCalculator = new StringCalculator("2 + 3 * 4");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(20);
    }

    @DisplayName("더 복잡한 사칙연산 테스트")
    @Test
    void complicated_calculate_test() {
        stringCalculator = new StringCalculator("10 * 5 / 10 + 9 - 4 * 5");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(50);
    }

    @DisplayName("2 + 3 / 4 * 2 값 테스트")
    @Test
    void step2_example_value_test() {
        stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        stringCalculator.returnResult(stringCalculator.inputDatas);
        assertThat(stringCalculator.result).isEqualTo(10);
    }


}
