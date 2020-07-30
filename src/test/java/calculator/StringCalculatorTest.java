package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @DisplayName("문자열 계산기에 null이나 공백이 들어간 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"null", "", " "})
    void blankTest(String data) {
        String testData = "null".equals(data) ? null : data;
        assertThatIllegalArgumentException()
            .isThrownBy(()->new StringCalculator(testData))
            .withMessage(StringCalculator.ERROR_MSG_BLANK)
        ;
    }


    @DisplayName("문자열 계산기에 사칙연산이 아닌 다닌 다른 문자열이 추가된 경우")
    @ParameterizedTest
    @ValueSource(strings = {"111", "----1//2", "3@@@4", "1 / 2 ----", "1FAEF##$%@@!@#$", "2 - 3 + 2 -"})
    void operatorErrorTest(String data) {
        String testData = "null".equals(data) ? null : data;
        assertThatIllegalArgumentException()
            .isThrownBy(()->new StringCalculator(testData))
            .withMessage(StringCalculator.ERROR_MSG_NOT_SUPPORT_STR)
        ;
    }


    @ParameterizedTest
    @CsvSource(value={
        "2 + 3=5"
        , "2 + 3 + 5=10"
        , "2 + 3 * 4 / 2=10"
    }
    ,delimiter = '=')
    void calculation(String data, int result) {
        StringCalculator stringCalculator = new StringCalculator(data);
        assertThat(stringCalculator.calculation()).isEqualTo(result);
    }
}
