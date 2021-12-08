package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {

    @Test
    @DisplayName("add 테스트")
    void add() {
        Number source = new Number(3);
        Number operand = new Number(1);
        Number expectedResult = new Number(4);

        Number result = source.add(operand);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("subtract 테스트")
    void subtract() {
        Number source = new Number(3);
        Number operand = new Number(1);
        Number expectedResult = new Number(2);

        Number result = source.subtract(operand);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("multiply 테스트")
    void multiply() {
        Number source = new Number(3);
        Number operand = new Number(4);
        Number expectedResult = new Number(12);

        Number result = source.multiply(operand);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("dividedBy 테스트")
    void dividedBy() {
        Number source = new Number(4);
        Number operand = new Number(2);
        Number expectedResult = new Number(2);

        Number result = source.dividedBy(operand);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("dividedBy 테스트: 0으로 나누는 경우 IllegalArgumentException이 발생한다.")
    void dividedByZero() {
        Number source = new Number(4);
        Number operand = new Number(0);

        assertThatIllegalArgumentException().isThrownBy(() ->
                source.dividedBy(operand)
        );
    }
}
