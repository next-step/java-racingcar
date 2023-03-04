package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void plusTest() {
        assertThat(calculator.plus(1,1)).isEqualTo(2);
    }

    @Test
    @ValueSource(ints = {1, 2})
    void minusTest() {
        assertThat(calculator.minus(1,1)).isEqualTo(0);
    }

    @Test
    @ValueSource(ints = {1, 2})
    void multiTest() {
        assertThat(calculator.multi(1,1)).isEqualTo(2);
    }

    @Test
    @ValueSource(ints = {1, 2})
    void divTest() {
        assertThat(calculator.div(1,1)).isEqualTo(1);
    }

    @Test
    void inputNullTest() {

    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void nullCheckTest(final String strings) {
        calculator.calculator(strings);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@"})
    void wordCheckTest(String strings) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> calculator.calSub(strings, 0 , 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3+33^5/2-2"})
    void wordCheckTest2(String strings) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> calculator.calSub(strings, 0 , 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3+33*5/2-2"})
    void calculatorTest(final String strings) {
        calculator.calculator(strings);
    }
}
