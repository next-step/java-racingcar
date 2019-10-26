package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringcalculator.parser.StringParser;
import stringcalculator.store.CalculatorBuffer;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1 * 3:3", "1 - 2:-1", "10 / 2:5"}, delimiter = ':')
    void calculate_정상적인_계산성공(String input, Double answer) {
        //given
        String[] parsedInputs = StringParser.parse(input);
        CalculatorBuffer calculatorBuffer = new CalculatorBuffer(parsedInputs);

        //when
        //then
        assertThat(StringCalculator.calculate(calculatorBuffer)).isEqualTo(answer);
    }

}