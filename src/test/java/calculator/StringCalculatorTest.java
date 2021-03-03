package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    String[] data = "5 * 3 - 5 / 2".split(" ");

    int result = 0;
    int temp = 0;


    @DisplayName("단순 덧셈 테스트")
    @Test
    void simple_addition_test() {
        String[] data = "2 + 5".split(" ");
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                result = Integer.parseInt(data[i-1]) + Integer.parseInt(data[i+1]);
            }
        }
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("n자릿수 덧셈")
    void addition_of_n_test() {
        String[] data = "123 + 50".split(" ");
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            if (!Character.isDigit(data[i].charAt(0))) {
                result = Integer.parseInt(data[i-1]) + Integer.parseInt(data[i+1]);
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
                result = Integer.parseInt(data[i-1]) / Integer.parseInt(data[i+1]);
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
                operation(data[i], data[i+1]);
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
        }

        result = temp;

    }



}
