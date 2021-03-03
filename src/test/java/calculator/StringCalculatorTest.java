package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @DisplayName("사용자가 입력한 입력 값이 null이 오거나 빈 공백 문자일 경우")
    @Test
    void check_user_input_value() {
        StringCalculator stringCalculator = new StringCalculator("5 + 3");

        assertThatThrownBy(() -> {
            stringCalculator.checkInputValue(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("숫자인지 연산자인지 구분하기 위한 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"5", "+", "3"}) // 테스트케이스가 일부로 깨지기 위해 연산자를 대입함
    void isDigit_test(String data) {
        assertThat(Character.isDigit(data.charAt(0))).isTrue();
    }

    @DisplayName("단순 사칙연산 테스트")
    @ParameterizedTest()
    @CsvSource(value = {"5 + 3:8", "5 - 3:2", "5 * 3:15", "10 / 2:5"}, delimiter = ':')
    void four_rule_calculations_test(String input, Integer result) {
        StringCalculator stringCalculator = new StringCalculator(input);
        stringCalculator.calculate(stringCalculator.inputDatas);

        assertThat(stringCalculator.result).isEqualTo(result);


    }

    @DisplayName("2 + 3 / 4 * 2 값 테스트")
    @Test
    void step2_example_value_test() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        stringCalculator.calculate(stringCalculator.inputDatas);

        assertThat(stringCalculator.result).isEqualTo(10);


    }
}
