import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
요구사항
        사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
        문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
        예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
@DisplayName("문자열 계산기")
public class CalculatorTest {

    @Test
    @DisplayName("입력한 문자열의 사칙연산 결과를 반환한다")
    public void operationTest() {

        Calculator sut = new Calculator();

        int actual = sut.calculate("1 + 2 + 3");

        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("null이 입력되면 0을 반환한다")
    public void nullTest() {
        Calculator sut = new Calculator();

        int actual = sut.calculate(null);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("+를 구분자로한 숫자 두개 문자열 입력하면 두 수의 합을 반환한다")
    public void twoNumberAddTest() {
        Calculator sut = new Calculator();

        int actual = sut.calculate("1+2");

        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("+연산자가 여러번 등장하는 문자열을 입력하면 숫자의 합을 반환한다")
    public void multipleNumberInputCalculateTest() {
        Calculator sut = new Calculator();

        int actual = sut.calculate("1+2+3");

        assertThat(actual).isEqualTo(6);
    }


    @Test
    @DisplayName("1+2-1=2")
    public void sumMinusTest() {
        Calculator sut = new Calculator();

        int actual = sut.calculate("1+2-1");

        assertThat(actual).isEqualTo(2);
    }


    @Test
    @DisplayName("음수를 입력하면 예외 발생한다")
    public void negativeShouldFailTest() {
        Calculator sut = new Calculator();

        Assertions.assertThrows(IllegalStateException.class, () -> sut.calculate("-2+1"));
    }



}
