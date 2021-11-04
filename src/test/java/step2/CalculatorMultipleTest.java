package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorMultipleTest {

    @ParameterizedTest
    @DisplayName("유효한 숫자 3개와 사칙연산 기호를 사용하여 연산한다.")
    @CsvSource(value={"1 + 2 * 3 : 9"}, delimiter = ':')
    public void calcMulti(String input, int expected) {
        MyNumber result = Calculator.calculateMulti(input);

        Assertions.assertThat(result.getNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효한 숫자 여러개와 사칙연산 기호를 사용하여 연산한다.")
    @CsvSource(value={"1 + 2 * 3 / 3 + 5 - 2 * 10 + 3: 63"}, delimiter = ':')
    public void calcMulti2(String input, int expected) {
        MyNumber result = Calculator.calculateMulti(input);

        Assertions.assertThat(result.getNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 숫자로 예외가 발생한다.")
    @CsvSource(value={"1 + 2b * 3 / 3 + 5 - 2 * 10 + 3: 유효하지 않은"}, delimiter = ':')
    public void calcInvalidNumber(String input, String expected) {
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculateMulti(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }
    
    @Test
    @DisplayName("유효하지 않은 사칙연산 기호로 예외가 발생한다.")
    public void calcInvalidOperator() {
        String input = "1 + 2 * 3 // 3 + 5";


        Assertions.assertThatThrownBy( () -> {
            Calculator.calculateMulti(input);
        }).hasMessageContaining("유효하지 않은 사칙연산");
    }

}
