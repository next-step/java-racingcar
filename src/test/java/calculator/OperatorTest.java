package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Operator enum 의 연산 기능을 적용한다.")
    void applyOperator() {
        assertAll(
            () -> assertThat(Operator.ADDITION.calculation.apply(1, 2)).isEqualTo(3),
            () -> assertThat(Operator.SUBTRACTION.calculation.apply(4, 7)).isEqualTo(-3),
            () -> assertThat(Operator.MULTIPLICATION.calculation.apply(10, 0)).isZero(),
            () -> assertThat(Operator.DIVISION.calculation.apply(121, 11)).isEqualTo(11)
        );
    }

}
