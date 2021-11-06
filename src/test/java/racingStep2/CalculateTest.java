package racingStep2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        int value1 = 3;
        int value2 = 5;

        assertThat(Calculate.add(value1, value2)).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest() {
        int value1 = 5;
        int value2 = 3;

        assertThat(Calculate.subtract(value1, value2)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplyTest() {
        int value1 = 3;
        int value2 = 5;

        assertThat(Calculate.multiply(value1, value2)).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest() {
        int value1 = 8;
        int value2 = 4;

        assertThat(Calculate.divide(value1, value2)).isEqualTo(2);
    }
}
