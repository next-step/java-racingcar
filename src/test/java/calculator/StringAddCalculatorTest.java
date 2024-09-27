package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @ParameterizedTest(name = ", 혹은 : 문자를 포함한 문자열 {0} 이 입력되면, 피연산자들을 구한 뒤, 더하여 결과값 {1} 을 구한다.")
    @CsvSource(value = {
            "|0", "''|0",
            "0|0", "1|1",
            "1,2|3", "1:2|3",
            "1,2,3|6", "1:2,3|6", "1,2:3|6", "1:2:3|6",
    }, delimiter = '|')
    @DisplayName(", 혹은 : 문자를 포함한 문자열이 입력되면, 피연산자들을 구한 뒤, 더하여 결과값을 구한다.")
    void sum(String input, int expected) {
        StringAddCalculator addCalculator = new StringAddCalculator(input);
        int actual = addCalculator.sum();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("//와 \n 사이 문자를 포함한 문자열이 입력되면, 피연산자들을 구한 뒤, 더하여 결과값을 구한다.")
    void customSum() {
        StringAddCalculator addCalculator = new StringAddCalculator("//:\n1:2:3");
        int actual = addCalculator.sum();

        assertThat(actual).isEqualTo(6);
    }

    @ParameterizedTest(name = "숫자 이외의 값 또는 음수를 포함한 문자열 {0} 이 입력되면, RuntimeException 예외를 throw 한다.")
    @ValueSource(strings = {
            "a,1,2", "a:1,2", "a,1:2", "a;1:2",
            "-1,1,2", "-1:1,2", "-1,1:2", "-1:1:2",
    })
//    @DisplayName("숫자 이외의 값 또는 음수를 포함한 문자열이 입력되면, RuntimeException 예외를 throw 한다.")
    void negativeNumberOrNotNumberSumError(String input) {
        assertThatThrownBy(() -> new StringAddCalculator(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("입력할 수 없습니다.");
    }
}
