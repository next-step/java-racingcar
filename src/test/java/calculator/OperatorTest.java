package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperatorTest {

    @Test
    @DisplayName("Operator 클래스의 of 메소드로 객체를 생성한다")
    public void 테스트_Operator_of() {
        assertThat(Operator.of("+")).isEqualTo(Operator.ADDITION);
        assertThat(Operator.of("-")).isEqualTo(Operator.SUBSTITUTION);
        assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLICATION);
        assertThat(Operator.of("/")).isEqualTo(Operator.DIVISION);
    }

    @Test
    @DisplayName("Operator 클래스의 of 메소드로 객체를 생성할 때 사칙연산기호가 아닌 경우 " +
            "IllegalArgumentException 예외가 발생한다.")
    public void 테스트_Operator_of_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Operator.of("&"));
    }

    @Test
    @DisplayName("Operator 클래스의 calculate 메소드는 사칙 연산을 수행하여 결과를 반환한다.")
    public void 테스트_Operator_calculate() {
        MyNumber first = new MyNumber("4");
        MyNumber second = new MyNumber("2");
        assertThat(Operator.ADDITION.calculate(first, second)).isEqualTo(new MyNumber("6"));
        assertThat(Operator.SUBSTITUTION.calculate(first, second)).isEqualTo(new MyNumber("2"));
        assertThat(Operator.MULTIPLICATION.calculate(first, second)).isEqualTo(new MyNumber("8"));
        assertThat(Operator.DIVISION.calculate(first, second)).isEqualTo(new MyNumber("2"));
    }
}