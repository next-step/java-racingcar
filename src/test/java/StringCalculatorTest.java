import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp () {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("빈값, 공백 체크 throw IllegalArgumentException")
    @ValueSource(strings = {"", " "})
    void isBlank (String str) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.isNotBlank(str))
                .withMessage("연산자가 빈값 또는 null입니다.");
    }

    @ParameterizedTest
    @DisplayName("계산")
    @CsvSource(value = {"1:+:2:3", "3:-:1:2", "4:*:2:8", "6:/:2:3"}, delimiter = ':')
    void calculator(double leftNumber, String operator, double rightNumber, int result) {
        assertThat(stringCalculator.calculator(leftNumber, operator, rightNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("연산자 가져오기")
    @CsvSource(value = {"2 + 3 * 4 / 2:1:+", "2 + 3 * 4 / 2:3:*", "2 + 3 * 4 / 2:5:/"}, delimiter = ':')
    void getOperator(String inputString, int index, String result) {
        String[] expressionArray = inputString.split(" ");
        assertThat(stringCalculator.getOperator(expressionArray, index)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("오른쪽 숫자 가져오기")
    @CsvSource(value = {"2 + 3 * 4 / 2:1:3", "2 + 3 * 4 / 2:3:4", "2 + 3 * 4 / 2:5:2"}, delimiter = ':')
    void getRightNumber(String inputString, int index, String result) {
        String[] expressionArray = inputString.split(" ");
        assertThat(stringCalculator.getRightNumber(expressionArray, index)).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("숫자 체크 throw IllegalArgumentException")
    @ValueSource(strings = {"a"})
    void isDigit (String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.isDigit(number))
                .withMessage("숫자가 아닙니다.");
    }
}
