package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.Operator.DIVIDE;
import static step2.Operator.MINUS;
import static step2.Operator.MULTIPLY;
import static step2.Operator.PLUS;

@DisplayName("Operator Enum operate")
public class OperatorTest {
    @DisplayName("PLUS 연산")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = {"3:4:7", "1:10:11"}, delimiter = ':')
    public void operatePlus(Integer input1, Integer input2, Integer expectedResult) {
        Integer result = PLUS.operate(input1, input2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("MINUS 연산")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource(value = {"5:4:1", "6:10:-4"}, delimiter = ':')
    public void operateMinus(Integer input1, Integer input2, Integer expectedResult) {
        Integer result = MINUS.operate(input1, input2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("MULTIPLY 연산")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(value = {"3:6:18", "-1:10:-10"}, delimiter = ':')
    public void operateMultiply(Integer input1, Integer input2, Integer expectedResult) {
        Integer result = MULTIPLY.operate(input1, input2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("DIVIDE 연산")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource(value = {"3:4:0", "100:10:10", "99:10:9"}, delimiter = ':')
    public void operateDivide(Integer input1, Integer input2, Integer expectedResult) {
        Integer result = DIVIDE.operate(input1, input2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("symbol에 해당하는 Operator enum 찾기")
    @ParameterizedTest
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    public void findOperator(String symbol, Operator expectedOperator) {
        Operator operator = Operator.fromSymbol(symbol);

        assertThat(operator).isEqualTo(expectedOperator);
    }

    @DisplayName("symbol에 해당하지 않는 Operator를 찾을 때")
    @Test
    public void findOperatorByInvalidSymbol() {
        assertThatThrownBy(() -> {
            Operator.fromSymbol("invalid");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid symbol");
    }

    @DisplayName("symbol에 해당하는 Operator가 있는지 여부")
    @ParameterizedTest(name = "\"{0}\" is contained in Operator -> {1}")
    @CsvSource(value = {"+:true", "invalid:false"}, delimiter = ':')
    public void containsSymbol(String symbol, boolean expectedResult) {
        boolean result = Operator.contains(symbol);

        assertThat(result).isEqualTo(expectedResult);
    }


}