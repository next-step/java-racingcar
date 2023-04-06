package calculator;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("[3] 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    public void sumTest1() {
        List<Integer> given = List.of(1, 2, 3, 4);
        Integer actual = calculator.sumAll(given);
        assertThat(actual).isEqualTo(10);
    }
}
