package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"6 / 3 - 5", "6 * 3 - 5", "0", "1+1"})
    public void stringCalculatingProcessor(String inputValue) {
            final Calculator calculator = new Calculator();
            assertThat(calculator.stringCalculatingProcessor(inputValue)).isInstanceOf(Integer.class);
    }
}