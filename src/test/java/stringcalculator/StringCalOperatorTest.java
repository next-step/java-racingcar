package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.util.StringCalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalOperatorTest {

    //******** 심화 : enum 변경에 따른 WRONG_OPERATOR_SYMBOL, DIVIDE_BY_ZERO 테스트 이동 (08.02)//
    @DisplayName("지정 문자열 외 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"[", "%", "^", " "})
    public void not_calculable_symbol (String operator) {
        assertThatThrownBy(() ->
            StringCalOperator.findOperation(operator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.WRONG_OPERATOR_SYMBOL);
    }

    @DisplayName("나눗셈 0으로 나눌 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4/0", "0/0"}, delimiter = '/')
    public void divide_by_zero (int lVal, int rVal){
        assertThatThrownBy(() -> {
            StringCalOperator.DIV.applyAsInt(lVal, rVal);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.DIVIDE_BY_ZERO);
    }
}
