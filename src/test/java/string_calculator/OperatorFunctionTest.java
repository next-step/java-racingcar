package string_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorFunctionTest {

    @DisplayName("add 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:2:3",
            "0:2:2",
            "9:2:11"
    }, delimiter = ':')
    public void addTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(OperatorFunction.PLUS.operate(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("minus 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:2:-1",
            "0:2:-2",
            "9:2:7"
    }, delimiter = ':')
    public void minusTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(OperatorFunction.MINUS.operate(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("multiply 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:2:2",
            "0:2:0",
            "9:2:18"
    }, delimiter = ':')
    public void multiTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(OperatorFunction.MULTIPLY.operate(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("divide 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1:2:0",
            "0:2:0",
            "9:2:4"
    }, delimiter = ':')
    public void divideTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(OperatorFunction.DIVIDE.operate(factor1, factor2)).isEqualTo(expect);
    }
}
