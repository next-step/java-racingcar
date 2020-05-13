package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @ParameterizedTest
    @DisplayName("연산 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10", "1 + 0 = 1", "1 - 2 = -1", "1 2 2"}, delimiter = '=')
    void calculateTest(String value, String expected){
        assertThat(stringCalculator.calculate(value)).isEqualTo(Integer.parseInt(expected));
    }

//    @ParameterizedTest
//    @DisplayName("입력값이 공백일 때 테스트")
//    @ValueSource(strings = {""})
//    void checkNullTest(String value){
//        assertThatThrownBy(() -> stringCalculator.calculate(value))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("공백입니다.");
//
//    }
}
