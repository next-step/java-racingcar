package stringCalculator;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    @ParameterizedTest
    @CsvSource(value = {"2 4:6", "5 9:14"}, delimiter = ':')
    void plusTest(String input, String expected) {
        String[] xy = input.split(" ");

        int result = (int) Operation.PLUS.calc(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));

        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 4:-2", "9 5:4"}, delimiter = ':')
    void minusTest(String input, String expected) {
        String[] xy = input.split(" ");

        int result = (int) Operation.MINUS.calc(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));

        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 4:8", "5 9:45"}, delimiter = ':')
    void multiplyTest(String input, String expected) {
        String[] xy = input.split(" ");

        int result = (int) Operation.MULTIPLY.calc(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));

        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"4 2:2", "9 3:3"}, delimiter = ':')
    void divideTest(String input, String expected) {
        String[] xy = input.split(" ");

        int result = (int) Operation.DIVIDE.calc(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]));

        assertThat(result).isEqualTo(Integer.valueOf(expected));
    }
}
