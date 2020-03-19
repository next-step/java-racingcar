package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @ParameterizedTest
    @DisplayName("사칙연산 기호로 적절한 Operator 객체를 찾는 테스트")
    @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
    public void isSymbol_test(String symbol, String operatorName) {
        assertThat(Operator.of(symbol)).isEqualTo(Operator.valueOf(operatorName));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 기호로 Operator 객체를 찾으려고 하면 IllegalArgumentException")
    public void operator_exception_test() {
        assertThatIllegalArgumentException().isThrownBy(() -> assertThat(Operator.of("^")).isEqualTo(DIVIDE));
    }

}