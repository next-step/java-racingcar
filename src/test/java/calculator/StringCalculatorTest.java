package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @DisplayName("공백 문자열 예외 처리 확인")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void invalidInputTest(String strExp) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(strExp))
                .withMessageContaining("빈 문자열이 입력되었습니다.");
    }

    @DisplayName("계산 결과")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - 3,0", "2 * 2 / 4,1"})
    void calculateTest(String strExp, int expected) {
        int result = StringCalculator.calculate(strExp);

        assertThat(result).isEqualTo(expected);
    }
}
