package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    private int defaultNumber;

    @BeforeEach
    void setUp() {
        defaultNumber = 2;
    }

    @CsvSource(value = {"*:true", "/:true", "-:true", "/:true", "!:false"}, delimiter = ':')
    @ParameterizedTest
    void isContains_메소드를_검증한다(String symbol, boolean expected) {
        assertThat(Operator.isContains(symbol)).isEqualTo(expected);
    }

    @CsvSource(value = {"*:true", "/:true", "-:true", "/:true", "!:false"}, delimiter = ':')
    @ParameterizedTest
    void getOperator_메소드를_통해_Operator가_null이_아닌지_검증한다(String symbol, boolean expected) {
        assertThat(Operator.isContains(symbol)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=3", "2=4", "-1=1", "-3=-1"}, delimiter = '=')
    void 덧셈(int endNumber, int result) {
        assertThat(Operator.PLUS.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "2=0", "-1=3", "-3=5"}, delimiter = '=')
    void 뺄셈(int endNumber, int result) {
        assertThat(Operator.MINUS.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=1"}, delimiter = '=')
    void 나눗셈(int endNumber, int result) {
        assertThat(Operator.DIVIDE.apply(defaultNumber, endNumber)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=2", "2=4", "3=6"}, delimiter = '=')
    void 곱셈(int endNumber, int result) {
        assertThat(Operator.MULTIPLY.apply(defaultNumber, endNumber)).isEqualTo(result);
    }
}