package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 및 빈 문자열 체크 테스트 코드")
    void nullAndEmptyCheck(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.nullAndEmptyCheck(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10",
            "12 - 2 - 2 - 0 + 1 = 9",
            "13 * 2 - 10 = 16",
            "3 + 3 + 3 = 9",
            "0 / 1 = 0"}, delimiter = '=')
    void calculateTest(String input, String expected) {
        assertThat(stringCalculator.calculation(input)).isEqualTo(Integer.parseInt(expected));
    }
}
