package step2;

import StringCalculator.CalculatorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTypeTest {

    @DisplayName("연산자를 통해서 CacularotType을 가지고 옵니다.")
    @ParameterizedTest
    @CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLE", "/:DIVIDE"}, delimiter = ':')
    void getCaculatorTypeWithSymbolsTest(final String symbol, final CalculatorType type) {
        assertThat(CalculatorType.getCalculatorWithSymbol(symbol)).isEqualTo(type);
    }

    @DisplayName("연산자가 아닌 문자를 넣으면 에러가 발생합니다.")
    @Test
    void ErrorGettingCalculatorTypeTest() {
        assertThatThrownBy(() ->{
           CalculatorType.getCalculatorWithSymbol("%");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
