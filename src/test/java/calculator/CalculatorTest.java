package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import caculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("쉼표를 구분자로 가지는 경우")
    void commaDelimiterTest() {
        assertThat(
                Calculator.sum("1,2,3")
        ).isEqualTo(6);
    }

}
