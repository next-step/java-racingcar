package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    String[] data = "5 * 3 - 5 / 2".split(" ");

    int result = 0;
    int temp = 0;

    @DisplayName("사용자가 입력한 입력 값이 null이 오거나 빈 공백 문자일 경우")
    @Test
    void check_user_input_value() {
        StringCalculator stringCalculator = new StringCalculator("5 + 3");

        assertThatThrownBy(() -> {
            stringCalculator.checkInputValue("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("숫자인지 연산자인지 구분하기 위한 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"5", "+", "3"})
    @Test
    void isDigit_test(String data) {
        assertThat(Character.isDigit(data.charAt(0))).isTrue();
    }


    @DisplayName("단순 덧셈 테스트")
    @Test
    void simple_addition_test() {
        StringCalculator stringCalculator = new StringCalculator("5 + 3");
        stringCalculator.calculate(stringCalculator.input);

        assertThat(stringCalculator.result).isEqualTo(8);
    }

    @DisplayName("단순 뺄셈 테스트")
    @Test
    void simple_substraction_test() {
        StringCalculator stringCalculator = new StringCalculator("5 - 3");
        stringCalculator.calculate(stringCalculator.input);

        assertThat(stringCalculator.result).isEqualTo(2);
    }

    @DisplayName("단순 곱하기 테스트")
    @Test
    void simple_multiplication_test() {
        StringCalculator stringCalculator = new StringCalculator("5 * 3");
        stringCalculator.calculate(stringCalculator.input);

        assertThat(stringCalculator.result).isEqualTo(15);
    }

    @DisplayName("단순 나누기 테스트")
    @Test
    void simple_division_test() {
        StringCalculator stringCalculator = new StringCalculator("10 / 2");
        stringCalculator.calculate(stringCalculator.input);

        assertThat(stringCalculator.result).isEqualTo(5);
    }

    @Test
    @DisplayName("n자릿수 덧셈")
    void addition_of_n_test() {
        StringCalculator stringCalculator = new StringCalculator("10 + 20");
        stringCalculator.calculate(stringCalculator.input);

        assertThat(stringCalculator.result).isEqualTo(30);
    }

    @DisplayName("n자릿수 나눗셈")
    @Test
    void divide_of_n_test() {
        StringCalculator stringCalculator = new StringCalculator("20 / 10");
        stringCalculator.calculate(stringCalculator.input);

        assertThat(stringCalculator.result).isEqualTo(2);
    }

    @DisplayName("4칙 연산 테스트")
    @Test
    void four_rule_calculations_test() {

        temp = Integer.parseInt(data[0]);

        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                operation(data[i], data[i + 1]);
            }
        }
        assertThat(result).isEqualTo(5);
    }

    public void operation(String operation, String value2) {

        switch (operation) {
            case "+":
                temp += Integer.parseInt(value2);
                break;

            case "-":
                temp -= Integer.parseInt(value2);
                break;

            case "*":
                temp *= Integer.parseInt(value2);
                break;

            case "/":
                temp /= Integer.parseInt(value2);
                break;
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        result = temp;

    }

}
