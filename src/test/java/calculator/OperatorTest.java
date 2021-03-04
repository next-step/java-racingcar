package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    @DisplayName("문자열 연산자로 Operator 를 생성한다")
    void createOperatorFromString() {
        assertAll(
            () -> assertThat(Operator.createOperator("+")).isEqualTo(Operator.ADDITION),
            () -> assertThat(Operator.createOperator("-")).isEqualTo(Operator.SUBTRACTION),
            () -> assertThat(Operator.createOperator("*")).isEqualTo(Operator.MULTIPLICATION),
            () -> assertThat(Operator.createOperator("/")).isEqualTo(Operator.DIVISION)
        );
    }

    @Test
    @DisplayName("사칙연산과 관련된 연산자가 아니면 예외 처리한다.")
    void throwIllegalArgumentExceptionIfStringIsNotValidOperator() {
        assertThatThrownBy(() -> Operator.createOperator("%")).isInstanceOf(IllegalArgumentException.class);
    }
}
