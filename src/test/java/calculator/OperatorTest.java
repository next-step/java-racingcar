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

    @ParameterizedTest
    @CsvSource(value = {"2,5,7", "3,8,11", "1,1,2"})
    @DisplayName("덧셈 로직 테스트하기")
    void plusTest(int x, int y, int expected) {
        assertThat(Operator.PLUS.operate(x,y)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5,0", "8,3,5", "8,11,-3"})
    @DisplayName("뺄셈 로직 테스트하기")
    void minusTest(int x, int y, int expected) {
        assertThat(Operator.MINUS.operate(x,y)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5,25", "8,3,24", "8,11,88"})
    @DisplayName("뺄셈 로직 테스트하기")
    void timesTest(int x, int y, int expected) {
        assertThat(Operator.TIMES.operate(x,y)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,5,2", "6,2,3"})
    @DisplayName("나눗셈 로직 테스트하기")
    void divideTest(int x, int y, int expected) {
        assertThat(Operator.DIVIDE.operate(x,y)).isEqualTo(expected);
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
