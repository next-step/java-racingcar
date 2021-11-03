package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by owen.ny on 2021/11/03.
 */
class OperatorTest {

    @Test
    public void 생성() {
        assertThat(Operator.of("+")).isEqualTo(Operator.ADDITION);
        assertThat(Operator.of("-")).isEqualTo(Operator.SUBSTITUTION);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLICATION);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVISION);
    }

    @Test
    public void 계산_연산자_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate("1 & 2");
        });
    }
    @Test
    public void 생성_연산자_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Operator.of("&");
        });
    }

    @Test
    public void 계산() {
        MyNumber first = new MyNumber("4");
        MyNumber second = new MyNumber("2");
        assertThat(Operator.ADDITION.calculate(first, second)).isEqualTo(new MyNumber("6"));
        assertThat(Operator.SUBSTITUTION.calculate(first, second)).isEqualTo(new MyNumber("2"));
        assertThat(Operator.MULTIPLICATION.calculate(first, second)).isEqualTo(new MyNumber("8"));
        assertThat(Operator.DIVISION.calculate(first, second)).isEqualTo(new MyNumber("2"));
    }
}