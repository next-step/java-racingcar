package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

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
                .withMessage("Unexpected value to find Operator '" + invalidStrValue + "'");
    }

    @Test
    @DisplayName("+(PLUS) 연산")
    void plusCalculate() {
        assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("-(MINUS) 연산")
    void minusCalculate() {
        assertThat(Operator.MINUS.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("*(MULTIPLY) 연산")
    void multiplyCalculate() {
        assertThat(Operator.MULTIPLY.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("/(DIVIDE) 연산")
    void divideCalculate() {
        assertAll(
                () -> assertThat(Operator.DIVIDE.calculate(4, 2)).isEqualTo(2),
                () -> assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0),
                () -> assertThat(Operator.DIVIDE.calculate(5, 2)).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("+(PLUS) 연산")
    void plusCalculate() {
        assertThat(Operator.PLUS.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("-(MINUS) 연산")
    void minusCalculate() {
        assertThat(Operator.MINUS.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("*(MULTIPLY) 연산")
    void multiplyCalculate() {
        assertThat(Operator.MULTIPLY.calculate(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("/(DIVIDE) 연산")
    void divideCalculate() {
        assertAll(
                () -> assertThat(Operator.DIVIDE.calculate(4, 2)).isEqualTo(2),
                () -> assertThat(Operator.DIVIDE.calculate(1, 2)).isEqualTo(0),
                () -> assertThat(Operator.DIVIDE.calculate(5, 2)).isEqualTo(2)
        );
    }
}