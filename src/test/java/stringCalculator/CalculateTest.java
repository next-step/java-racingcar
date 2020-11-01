package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringCalculator.exception.TypeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateTest {

    @DisplayName(value = "연산자에 따른 연산결과")
    @ParameterizedTest
    @CsvSource(value = {"+,2,3,5", "-,3,2,1", "*,5,5,25", "/,10,5,2"})
    void calculate(String operator, int firstNumber, int secondNumber, int expected) {
        // when
        int result = Calculate.calculate(operator, firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName(value = "enum 타입이 없으면 예외")
    @ParameterizedTest
    @ValueSource(strings = {"&", "!", "#", "("})
    void calculate(String operator) {
        // when
        assertThatThrownBy(() -> {
            Calculate.calculate(operator, 2, 3);
            // then
        }).isInstanceOf(TypeException.class)
                .hasMessageContaining("타입이 존재하지 않습니다.");
    }
}