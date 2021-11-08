package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("주어진 문자열에 +가 있으면 덧셈 연산을 수행한다")
    void addition() {
        String[] input = "2 + 3".split(" ");
        String operator = input[1];
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[2]);

        String addition = "+";
        int result = 0;

        if (addition.equals(operator)) {
            result = first + second;
        }

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("주어진 문자열에 -가 있으면 뺄셈 연산을 수행한다")
    void subtraction() {
        String[] input = "5 - 8".split(" ");
        String operator = input[1];
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[2]);

        String subtraction = "-";
        int result = 0;

        if (subtraction.equals(operator)) {
            result = first - second;
        }

        assertThat(result).isEqualTo(-3);
    }

    @Test
    @DisplayName("주어진 문자열에 *가 있으면 곱셈 연산을 수행한다")
    void multiplication() {
        String[] input = "3 * 4".split(" ");
        String operator = input[1];
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[2]);

        String multiplication = "*";
        int result = 0;

        if (multiplication.equals(operator)) {
            result = first * second;
        }

        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("주어진 문자열에 *가 있으면 곱셈 연산을 수행한다")
    void division() {
        String[] input = "4 / 2".split(" ");
        String operator = input[1];
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[2]);

        String division = "/";
        int result = 0;

        if (division.equals(operator)) {
            result = first / second;
        }

        assertThat(result).isEqualTo(2);
    }
}
