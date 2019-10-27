package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "+:PLUS",
            "-:MINUS",
            "*:MULTIPLY",
            "/:DIVIDE"
    }, delimiter = ':')
    void getOperator(String symbol, Operator operator) {
        assertThat(Operator.getOperator(symbol)).isEqualTo(operator);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "#",
            "**",
            "1"
    })
    void throwError(String operator) {
        assertThatThrownBy(() -> Operator.getOperator(operator))
                .isInstanceOf(IllegalArgumentException.class);
    }
}