package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

public class StringCalculator {

    int calculator(String str) {
        String[] cal_element = str.split(" ");
        int num1 = Integer.parseInt(cal_element[0]);

        for(int i=1; i<cal_element.length-1; i+=2) {
            switch (cal_element[i]) {
                case "+":
                    num1 += Integer.parseInt(cal_element[i+1]);
                    break;
                case "-":
                    num1 -= Integer.parseInt(cal_element[i+1]);
                    break;
                case "*":
                    num1 *= Integer.parseInt(cal_element[i+1]);
                    break;
                case "/":
                    num1 = (int)(num1/Integer.parseInt(cal_element[i + 1]));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return num1;
    }

    // 덧셈 테스트
    @ParameterizedTest
    @CsvSource(value = {"3 + 4:7", "2 + 5 + 8:15", "3 + 5 + 2:10"}, delimiter = ':')
    void plus(String calculation, int result) {
        assertThat(calculator(calculation)).isEqualTo(result);
    }

    // 뺄셈 테스트
    @ParameterizedTest
    @CsvSource(value = {"3 - 2:1", "5 - 2 - 3 - 1:-1"}, delimiter = ':')
    void minus(String calculation, int result) {
        assertThat(calculator(calculation)).isEqualTo(result);
    }

    // 곱셈 테스트
    @ParameterizedTest
    @CsvSource(value = {"3 * 2:6", "4 * 2 * 30:240"}, delimiter = ':')
    void multiply(String calculation, int result) {
        assertThat(calculator(calculation)).isEqualTo(result);
    }

    // 나눗셈 테스트
    @ParameterizedTest
    @CsvSource(value = {"3 / 2:1", "120 / 5 / 7:3"}, delimiter = ':')
    void division(String calculation, int result) {
        assertThat(calculator(calculation)).isEqualTo(result);
    }

    // 입력 값이 빈 공백 문자일 경우 테스트
    @ParameterizedTest
    @EmptySource
    void isEmpty(String input) {
        assertThatThrownBy(() -> {
            calculator(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 입력 값이 null일 경우 테스트
    @ParameterizedTest
    @NullSource
    void isNull(String input) {
        assertThatThrownBy(() -> {
            calculator(input);
        }).isInstanceOf(NullPointerException.class);
    }

    // 사칙연산 기호가 아닌 경우 테스트
    @ParameterizedTest
    @ValueSource(strings = {"3 + 2 & 7", "3 ) 2"})
    void operationError(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator(input);
        });
    }

    // 사칙 연산을 모두 포함할 경우 테스트
    @ParameterizedTest
    @CsvSource(value = {"3 + 2 - 7 * 5 / 3:-3", "100 * 3 - 4 + 7 / 9:33"}, delimiter = ':')
    void allOperation(String calculation, int result) {
        assertThat(calculator(calculation)).isEqualTo(result);
    }
}
