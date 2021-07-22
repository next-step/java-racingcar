package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "4 + 5:9"}, delimiter = ':')
    @DisplayName("+ 연산자가 있으면 덧셈 결과가 반환돠어야 한다.")
    void additionTest(String input, int expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add(input);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
