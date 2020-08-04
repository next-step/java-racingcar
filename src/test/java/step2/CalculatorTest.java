package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.calculator.AvailableCalculation;
import step2.common.ExceptionMessage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2","1 + 3:4","2 + 5:7"},delimiter = ':')
    public void addTest(String str, int result) {
        AvailableCalculation ac = new AvailableCalculation(str);
        assertThat(ac.calculate(str)).isEqualTo(result);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 - 1:0","3 - 1:2","10 - 3:7"},delimiter = ':')
    public void subtractTest(String str, int result) {
        AvailableCalculation ac = new AvailableCalculation(str);
        assertThat(ac.calculate(str)).isEqualTo(result);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 * 1:1","3 * 1:3","10 * 3:30"},delimiter = ':')
    public void multiplyTest(String str, int result) {
        AvailableCalculation ac = new AvailableCalculation(str);
        assertThat(ac.calculate(str)).isEqualTo(result);
    }

    @DisplayName("나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3 / 1:3","10 / 2:5","12 / 6:2"},delimiter = ':')
    public void divideTest(String str, int result) {
        AvailableCalculation ac = new AvailableCalculation(str);
        assertThat(ac.calculate(str)).isEqualTo(result);
    }

    @DisplayName("0으로 나눌 경우")
    @ParameterizedTest
    @CsvSource(value = {"3 / 0","10 / 0"})
    public void divideTest_by_Zero(String str) {
        AvailableCalculation ac = new AvailableCalculation(str);
        assertThatThrownBy(() -> {
            ac.calculate(str);
        }).withFailMessage(ExceptionMessage.DIVIDE_VALUE_IS_ZERO);
    }

    @DisplayName("통합 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 * 3 - 1 / 4:2","3 - 1 * 5 + 10 / 2:10"},delimiter = ':')
    public void totalOperationTest(String str, int result) {
        AvailableCalculation ac = new AvailableCalculation(str);
        assertThat(ac.calculate(str)).isEqualTo(result);
    }



}
