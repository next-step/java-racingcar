package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateTest {

    @DisplayName(value = "ADD Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "3,2,5", "5,5,10", "10,5,15"})
    void calculateAdd(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Calculate.ADD.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "SUBTRACT Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,-1", "3,2,1", "5,5,0", "10,5,5"})
    void calculateSubtract(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Calculate.SUBTRACT.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "DIVISION Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,0", "3,2,1", "5,5,1", "10,5,2"})
    void calculateDivision(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Calculate.DIVISION.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "MULTIPLE Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "3,2,6", "5,5,25", "10,5,50"})
    void calculateMultiple(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Calculate.MULTIPLE.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }
}