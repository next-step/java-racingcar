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

}