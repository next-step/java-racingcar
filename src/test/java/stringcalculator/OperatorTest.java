package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE"})
    @DisplayName("문자열로 Operator 찾기")
    void findBy(String strValue, Operator expectedOperator) {
        Operator operator = Operator.findBy(strValue);
        assertThat(operator).isSameAs(expectedOperator);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
    void findBy_failingCase() {
        String invalidStrValue = "&";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Operator.findBy(invalidStrValue))
                .withMessage("Unexpected strValue to find Operator '" + invalidStrValue + "'");
    }
}