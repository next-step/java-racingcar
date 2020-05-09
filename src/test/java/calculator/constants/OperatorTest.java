package calculator.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @CsvSource(value = {"*:true", "/:true", "-:true", "/:true", "!:false"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("isContains 메소드를 검증한다.")
    void isAllowOperatorTest(String symbol, boolean expected){
        assertThat(Operator.isContains(symbol)).isEqualTo(expected);
    }

    @CsvSource(value = {"*:true", "/:true", "-:true", "/:true", "!:false"}, delimiter = ':')
    @ParameterizedTest
    @DisplayName("getOperator 메소드를 통해 Operator가 null이 아닌지 검증한다.")
    void getOperatorTest(String symbol, boolean expected){
        assertThat(Objects.nonNull(Operator.getOperator(symbol))).isEqualTo(expected);
    }
}
