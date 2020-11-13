package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName(value = "ADD Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "3,2,5", "5,5,10", "10,5,15"})
    void calculateAdd(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Operator.ADD.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "SUBTRACT Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,-1", "3,2,1", "5,5,0", "10,5,5"})
    void calculateSubtract(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Operator.SUBTRACT.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "DIVISION Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,0", "3,2,1", "5,5,1", "10,5,2"})
    void calculateDivision(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Operator.DIVISION.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "MULTIPLE Test")
    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "3,2,6", "5,5,25", "10,5,50"})
    void calculateMultiple(int firstNumber, int secondNumber, int expected) {
        // when
        int result = Operator.MULTIPLE.calculate(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "0으로 나누면 예외")
    @Test
    void calculateDivisionZero() {
        // when
        assertThatThrownBy(() -> {
            Operator.DIVISION.calculate(10, 0);
            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}