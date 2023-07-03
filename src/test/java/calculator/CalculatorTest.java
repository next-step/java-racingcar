package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("콜론을 구분자로 가지는 경우")
    void colonDelimiterTest() {
        assertThat(
                Calculator.sum("1:2:3")
        ).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표 또는 콜론을 구분자로 가지는 경우")
    void basicDelimiterTest() {
        assertThat(
                Calculator.sum("1,2:3")
        ).isEqualTo(6);
    }

}
