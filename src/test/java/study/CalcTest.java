package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalcTest {

    private Calc calc;

    @BeforeEach
    void setUp() {
        calc = new CalcImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void test(String input) {
        assertThat(calc.cal(input)).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 - 1 * 4 / 2"})
    void test2(String input) {
        assertThat(calc.cal(input)).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3"})
    void plus(String input) {
        assertThat(calc.cal(input)).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 - 3"})
    void substract(String input) {
        assertThat(calc.cal(input)).isEqualTo(-1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 * 4"})
    void multiply(String input) {
        assertThat(calc.cal(input)).isEqualTo(12);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 2"})
    void division(String input) {
        assertThat(calc.cal(input)).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void throwIllegalArgumentExceptionIfInputIsNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calc.cal(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 # 2"})
    void throwIllegalArgumentExceptionIfInputContainsIllegalOperation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calc.cal(input));
    }

}
