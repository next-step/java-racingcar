package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SingleExpressionCalculatorTest {

    private SingleExpressionCalculator singleExpressionCalculator = null;

    @BeforeEach
    public void setUp() {
        singleExpressionCalculator = new SingleExpressionCalculator();
    }

    @DisplayName("add 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "0:2:2", "9:2:11"}, delimiter = ':')
    public void addTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(singleExpressionCalculator.add(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("minus 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "0:2:-2", "9:2:7"}, delimiter = ':')
    public void minusTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(singleExpressionCalculator.minus(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("multiply 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "0:2:0", "9:2:18"}, delimiter = ':')
    public void multiTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(singleExpressionCalculator.multiply(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("divide 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:0", "0:2:0", "9:2:4"}, delimiter = ':')
    public void divideTest(Integer factor1, Integer factor2, Integer expect) {
        assertThat(singleExpressionCalculator.divide(factor1, factor2)).isEqualTo(expect);
    }

    @DisplayName("calc 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:+:2:3","1:-:2:-1","3:*:2:6","3:/:2:1"}, delimiter = ':')
    public void divideTest(String factor1, String operand, String factor2, Integer expect) {

        SingleExpression singleExpression = new SingleExpression(new Operand(factor1), new Operator(operand), new Operand(factor2));

        assertThat(singleExpressionCalculator.calc(singleExpression)).isEqualTo(expect);
    }
}
