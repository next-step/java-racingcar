package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringCalculatorTest {

    @ParameterizedTest(name = "문자열 {0} 은 {1}을 반환한다")
    @CsvSource(value = {"10 + 15:25", "25 - 7:18", "18 * 3:54", "54 / 9:6", "10 + 15 - 7:18", "10 + 15 - 7 * 3 / 9:6"}, delimiter = ':')
    public void stringCalculate_ShouldReturnSumValue(String inputString, int expectedValue) {

        StringCalculator stringCalculator = new StringCalculator(inputString);

        assertThat(stringCalculator.stringCalculate()).isEqualTo(expectedValue);
    }

    @DisplayName("사직연산 기호가 아닌 경우 IllegalArgumentException 를 던진다")
    @Test
    public void stringCalculate_ShouldThrowIllegalArgumentException() {

        String inputString = "10 + 15 - 7 * 3 ^ 9";

        StringCalculator stringCalculator = new StringCalculator(inputString);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> stringCalculator.stringCalculate())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
