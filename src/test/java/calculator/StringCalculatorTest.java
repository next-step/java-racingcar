package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {
    @Test
    void addTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("1+2")).isEqualTo(3);
    }

    @Test
    void subTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("2-1")).isEqualTo(1);
    }

    @Test
    void mulTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("2*3")).isEqualTo(6);
    }

    @Test
    void diviTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("4/2")).isEqualTo(2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void name(String input) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.calculate(input));
    }

    @Test
    void numbersTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("1+2+3")).isEqualTo(6);
    }

    //2 + 3 * 4 / 2
    @Test
    void numbersTest2() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("2+3*4/2")).isEqualTo(10);
    }
}