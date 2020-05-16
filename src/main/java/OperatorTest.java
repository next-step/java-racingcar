import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Operator;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    private Operator operator;
    @BeforeEach
    void setUp() {
        operator = new Operator();
    }
    @DisplayName("+")
    @ParameterizedTest
    @CsvSource("'1','2'")
    void  plusTest(double a, double b) {
        assertThat(3).isEqualTo(operator.plus(a,b));
    }
    @DisplayName("-")
    @ParameterizedTest
    @CsvSource("'4','2'")
    void  minusTest(double a, double b) {
        assertThat(2).isEqualTo(operator.minus(a,b));
    }
    @DisplayName("*")
    @ParameterizedTest
    @CsvSource("'1','2'")
    void  multiplyTest(double a, double b) {
        assertThat(2).isEqualTo(operator.multiply(a,b));
    }
    @DisplayName("/")
    @ParameterizedTest
    @CsvSource("'4','2'")
    void  divideTest(double a, double b) {
        assertThat(2).isEqualTo(operator.divide(a,b));
    }
}
