package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2,10",
            "5 * 5 + 3 / 2,14",
            "0,0",
            "10 - 2 + 9 * 5 / 3,28"
    })
    @DisplayName("문자열 계산기 단위테스트 - 정상동작 ")
    void calculate_normal_isEqualTo(String input, int result) {
        assertThat(calculator.result(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+ 10 - 2 / 3",
            "2 + 2 -",
            "3 + 1 * 5 / 0",
            "null",
            " "
    })
    @DisplayName("문자열 계산기 단위테스트 - 비정상 input 값 입력시 예외 출력 ")
    void calculate_abnormal_ThrownByException(String input) {
        assertThatThrownBy(() -> {
            calculator.result(input);
        }).isInstanceOfAny(IllegalArgumentException.class,ArithmeticException.class);
    }

}
