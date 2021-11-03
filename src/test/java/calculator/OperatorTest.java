package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true", "/,true", ".,false", "0,false"})
    @DisplayName("사칙 연산 문자인지 확인하기")
    void isOperatorTest(String input, boolean expected) {
        assertThat(Operator.isOperator(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("덧셈 로직 테스트하기")
    void plusTest() {
        assertThat(Operator.PLUS.operate(2,5)).isEqualTo(7);
        assertThat(Operator.PLUS.operate(3,8)).isEqualTo(11);
        assertThat(Operator.PLUS.operate(1,1)).isEqualTo(2);
    }

    @Test
    @DisplayName("뺄셈 로직 테스트하기")
    void minusTest() {
        assertThat(Operator.MINUS.operate(5,5)).isEqualTo(0);
        assertThat(Operator.MINUS.operate(8,3)).isEqualTo(5);
        assertThat(Operator.MINUS.operate(8,11)).isEqualTo(-3);
    }

    @Test
    @DisplayName("뺄셈 로직 테스트하기")
    void timesTest() {
        assertThat(Operator.TIMES.operate(5,5)).isEqualTo(25);
        assertThat(Operator.TIMES.operate(8,3)).isEqualTo(24);
        assertThat(Operator.TIMES.operate(8,11)).isEqualTo(88);
    }

    @Test
    @DisplayName("나눗셈 로직 테스트하기")
    void divideTest() {
        assertThat(Operator.DIVIDE.operate(10,5)).isEqualTo(2);
        assertThat(Operator.DIVIDE.operate(6,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나눌때 예외 발생하는지 테스트")
    void divideWithZeroTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDE.operate(5,0))
                .withMessage("can't divide with 0");
    }

    @Test
    @DisplayName("연산자가 아닌 문자로 Operator get 할 때 예외발생 테스트")
    void getNotSymbolTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.get("0"))
                .withMessage("variable is not operator");
    }

    @Test
    @DisplayName("연산자에 맞는 Operator 가져오는지 get 테스트")
    void getSymbolTest() {
        assertThat(Operator.get("+")).isEqualTo(Operator.PLUS);
        assertThat(Operator.get("-")).isEqualTo(Operator.MINUS);
        assertThat(Operator.get("*")).isEqualTo(Operator.TIMES);
        assertThat(Operator.get("/")).isEqualTo(Operator.DIVIDE);
    }
}
