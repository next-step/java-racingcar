package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    @DisplayName("양수값이 들어오면, 양수값을 더한값을 반환한다.")
    void test1() {
        assertThat(StringCalculator.sum("1,2")).isEqualTo(3);
        assertThat(StringCalculator.sum("1,2,3")).isEqualTo(6);
    }

}
