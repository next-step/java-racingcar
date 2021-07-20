package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator stringCalculrator;

    @BeforeEach
    void setUp() {
        stringCalculrator = new StringCalculator();
    }

    @Test
    @DisplayName("숫자2개 덧셈기능")
    public void calcul_plus() {
        int plus = stringCalculrator.plus(2, 4);

        assertThat(plus).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자2개 뺄셈기능")
    public void calcul_minus() {
        int minus = stringCalculrator.minus(5, 3);

        assertThat(minus).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자2개 곱셈기능")
    public void calcul_multi() {
        int multi = stringCalculrator.multi(2, 4);

        assertThat(multi).isEqualTo(8);
    }

    @Test
    @DisplayName("숫자2개 나눗셈기능")
    public void calcul_divide() {
        int divide = stringCalculrator.divide(4, 2);

        assertThat(divide).isEqualTo(2);
    }

    @Test
    @DisplayName("입력값 null 체크 기능")
    public void null_check() {
        String checkValue = "2  3 +  + 1 / 2";

        assertThatThrownBy(() -> stringCalculrator.calculate(checkValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산 수식이 빈값입니다.");
    }

    @Test
    @DisplayName("사칙연산이 아닌 다른값 체크 기능")
    public void notExpression_check() {
        String checkValue = "2 ) 3 + 1 / 2";

        assertThatThrownBy(() -> stringCalculrator.calculate(checkValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 연산자가 아닙니다.");
    }

    @Test
    @DisplayName("사칙연산을 모두 포함하는 기능")
    public void calculator_operate_check() {
        String checkValue = "1 + 2 * 5 / 3";
        int result = stringCalculrator.calculate(checkValue);
        assertThat(result).isEqualTo(5);
    }

}