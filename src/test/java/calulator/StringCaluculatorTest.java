package calulator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCaluculatorTest {
    @Test
    void addTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("1+2")).isEqualTo(3);
    }

    @Test
    void subTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("2-1")).isEqualTo(1);
    }

    @Test
    void mulTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("2*3")).isEqualTo(6);
    }

    @Test
    void diviTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("4/2")).isEqualTo(2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void name(String input) {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCaluculator.calculate(input));
    }

    @Test
    void numbersTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("1+2+3")).isEqualTo(6);
    }
}