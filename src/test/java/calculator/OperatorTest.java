package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    public Operator operator = new Operator();

    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for add function")
    void testAdd(int a, int b) {
        assertThat(operator.add(a, b)).isEqualTo(a+b);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for subtract function")
    void testSubtract(int a, int b) {
        assertThat(operator.subtract(a, b)).isEqualTo(a-b);
    }


    @ParameterizedTest
    @CsvSource(value = {"10:5", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for divide function")
    void testDivide(int a, int b) {
        assertThat(operator.divide(a, b)).isEqualTo(a/b);
    }


    @ParameterizedTest
    @CsvSource(value = {"1:2", "4:120", "10983:92"}, delimiter = ':')
    @DisplayName("Test for multiply function")
    void testMultiply(int a, int b) {
        assertThat(operator.multiply(a, b)).isEqualTo(a*b);
    }

}
