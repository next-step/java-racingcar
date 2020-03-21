package step2;

import StringCalculator.CalculatorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTypeTest {

    @DisplayName("연산자를 통해서 CalculatorType 을 가지고옴")
    @ParameterizedTest
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLE", "/:DIVIDE"}, delimiter = ':')
    void getCaculatorTypeWithSymbolsTest(final String symbol, final CalculatorType type) {
        assertThat(CalculatorType.getCalculatorWithSymbol(symbol)).isEqualTo(type);
    }

    @DisplayName("연산자가 아닌 문자를 넣으면 에러 발생")
    @Test
    void ErrorGettingCalculatorTypeTest() {
        assertThatThrownBy(() -> {
            CalculatorType.getCalculatorWithSymbol("%");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실제 계산 연산을 진행")
    @ParameterizedTest
    @CsvSource(value = {"+:2:3:5", "-:5:2:3", "*:10:4:40", "/:12:4:3"}, delimiter = ':')
    void calculateTest(final String symbol, final Double firstNumber, final Double secondNumber, final Double answer) {
        final Double result = CalculatorType.getCalculatorWithSymbol(symbol)
                .calculate(firstNumber, secondNumber);
        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("0으로 나누는 경우 에러 발생")
    @Test
    void ErrorDeviceByZero() {
        assertThatThrownBy(() -> {
            CalculatorType.DIVIDE.calculate(2.0, 0.0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
