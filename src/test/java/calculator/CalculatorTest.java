package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    AddCalculator calculator = new AddCalculator();

    @DisplayName("문자열 입력이 주어졌을 때, 덧셈 결과를 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
        "1,2:3",
        "//;\n1;2;3"
    })
    void calculate(String input) {
        int actual = calculator.calculate(input);
        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("정수 리스트가 주어졌을 때, 리스트의 모든 요소의 합을 반환해야 한다.")
    @Test
    void calculate_givenIntegerList() {
        int actual = calculator.calculate(List.of(1, 2, 3));
        assertThat(actual).isEqualTo(6);
    }
}
