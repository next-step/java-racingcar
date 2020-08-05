import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Enum으로 구현한 계산 Operation Test")
class OperationTest {
    private static final char DELIMITER = ' ';

    @ParameterizedTest
    @CsvSource(value = {"1 + 4 5", "3 * 7 21", "4 / 2 2", "8 - 2 6"}, delimiter = DELIMITER)
    @DisplayName("여러가지 Value를 테스트 나누는 것보다 CsvSource 하나로 묶어서 Test")
    void enumCalculation_With_Parameter(String lValue, String operand, String rValue, int expected) {
        assertThat(Operation.findOperator(operand).calculate(lValue, rValue)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 ] 4", "4 / 0"}, delimiter = DELIMITER)
    @DisplayName("Exception Case를 하나로 묶어서 Test - Invalid Operand, Divide by Zero")
    void enumCalculation_Exception_With_Parameter(String lValue, String operand, String rValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Operation.findOperator(operand).calculate(lValue, rValue));
    }
}
