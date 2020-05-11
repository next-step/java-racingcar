package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("연산 테스트 입니다.")
    @CsvSource(value = {"2 + 3 * 4 / 2 = 10", "1 + 0 = 1", "1 - 2 = -1",}, delimiter = '=')
    void calculateTest(String value, String expected){
        assertThat(stringCalculator.calculate(value)).isEqualTo(Integer.parseInt(expected));
    }
}
