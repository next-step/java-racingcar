package calculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTypeTest {
    @ParameterizedTest
    @CsvSource({"+,6", "-,2", "*,8", "/,2"})
    @DisplayName("4,2 가 주어졌다고 가정할 때 연산자에 맞는 사칙연산이 수행된다.")
    void getOperationTypeTest(String operator, double expected) {
        double result = OperationType.getOperationType(operator)
                                     .getOperationResult(4, 2);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"**", "//", "notOperator"})
    @DisplayName("정의되지 않은 연산자가 들어올 경우 exception이 발생된다.")
    void getOperationTypeExceptionTest(String operator) {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> OperationType.getOperationType(operator));
    }
}
