package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    String[] data = "5 * 3 - 5 / 2".split(" ");

    int result = 0;
    int temp = 0;

    @DisplayName("연산에 필요한 문자열 자르기")
    @BeforeEach
    @Test
    void split_user_input() {
        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                result = Integer.parseInt(data[i - 1]) + Integer.parseInt(data[i + 1]);
            }
        }
    }

    @DisplayName("입력 값이 null이 오거나 빈 공백 문자일 경우")
    @Test
    void check_user_input_value() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThatThrownBy(() -> {
            stringCalculator.checkInputValue(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null이거나 빈 공백 문자입니다.");
    }

    @DisplayName("단순 덧셈 테스트")
    @Test
    void simple_addition_test() {
        String[] data = "5 + 3 ".split(" ");

        int addResult = 0;
        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                addResult = Integer.parseInt(data[i - 1]) + Integer.parseInt(data[i + 1]);
            }
        }
        assertThat(addResult).isEqualTo(8);
    }

    @DisplayName("단순 뺄셈 테스트")
    @Test
    void simple_substraction_test() {
        String[] data = "5 - 3 ".split(" ");

        int subResult = 0;
        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                subResult = Integer.parseInt(data[i - 1]) - Integer.parseInt(data[i + 1]);
            }
        }
        assertThat(subResult).isEqualTo(2);
    }

    @DisplayName("단순 곱하기 테스트")
    @Test
    void simple_multiplication_test() {
        String[] data = "5 * 3 ".split(" ");

        int mulResult = 0;
        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                mulResult = Integer.parseInt(data[i - 1]) * Integer.parseInt(data[i + 1]);
            }
        }
        assertThat(mulResult).isEqualTo(15);
    }

    @DisplayName("단순 나누기 테스트")
    @Test
    void simple_division_test() {
        String[] data = "10 / 2 ".split(" ");

        int divResult = 0;
        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                divResult = Integer.parseInt(data[i - 1]) / Integer.parseInt(data[i + 1]);
            }
        }
        assertThat(divResult).isEqualTo(5);
    }

    @Test
    @DisplayName("n자릿수 덧셈")
    void addition_of_n_test() {
        String[] data = "123 + 50".split(" ");
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                result = Integer.parseInt(data[i - 1]) + Integer.parseInt(data[i + 1]);
            }
        }
        assertThat(result).isEqualTo(173);
    }

    @DisplayName("n자릿수 나눗셈")
    @Test
    void divide_of_n_test() {
        String[] data = "20 / 2".split(" ");
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                result = Integer.parseInt(data[i - 1]) / Integer.parseInt(data[i + 1]);
            }
        }
        assertThat(result).isEqualTo(10);
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
