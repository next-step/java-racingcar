
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 숫자만있을시() {
        int output = stringCalculator.calculate("12");
        assertThat(output).isEqualTo(12);

        output = stringCalculator.calculate("-12");
        assertThat(output).isEqualTo(-12);
    }

    @Test
    void 더하기테스트() {
        int output = stringCalculator.calculate("1 + 2");
        assertThat(output).isEqualTo(3);
    }

    @Test
    void 빼기테스트() {
        int output = stringCalculator.calculate("3 - 2");
        assertThat(output).isEqualTo(1);

        output = stringCalculator.calculate("1 - 2");
        assertThat(output).isEqualTo(-1);
    }

    @Test
    void 나누기테스트() {
        int output = stringCalculator.calculate("10 / 2");
        assertThat(output).isEqualTo(5);

        output = stringCalculator.calculate("1 / 2");
        assertThat(output).isEqualTo(0);

        output = stringCalculator.calculate("-7 / -2");
        assertThat(output).isEqualTo(3);

        output = stringCalculator.calculate("7 / -2");
        assertThat(output).isEqualTo(-3);

        assertThatThrownBy(() -> stringCalculator.calculate("10 / 0"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @Test
    void 곱하기테스트() {
        int output = stringCalculator.calculate("10 * 2");
        assertThat(output).isEqualTo(20);

        output = stringCalculator.calculate("-1 * -2");
        assertThat(output).isEqualTo(2);

        output = stringCalculator.calculate("-1 * 2");
        assertThat(output).isEqualTo(-2);
    }

    @Test
    void 계산테스트() {
        int output = stringCalculator.calculate("2 + 3 * 4 / 2");
        assertThat(output).isEqualTo(10);

        output = stringCalculator.calculate("-1 * -2 + 8 * 30");
        assertThat(output).isEqualTo(480);
    }



    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1 a 1", "1 1 1"})
    public void 예외테스트(String input) {
        assertThatThrownBy(() -> stringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);

    }



}