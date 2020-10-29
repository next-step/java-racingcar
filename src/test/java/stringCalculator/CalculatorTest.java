package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("일반적인 상황에서의 동작 테스트")
    @CsvSource(value = "1 + 2 * 3 - 3 / 2:3", delimiter = ':')
    @ParameterizedTest
    void onHappyPath(String input, int expected) {
        Calculator calculator = new Calculator(input);

        int result = calculator.execute();

        assertThat(result).isEqualTo(expected);

    }




}