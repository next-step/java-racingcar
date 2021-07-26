package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleCalculatorTest {
    SimpleCalculator sc;

    @BeforeEach
    void setUp() {
        sc = new SimpleCalculator();
    }

    @Test
    @DisplayName("더하기 테스트")
    void plusTest() {
        assertThat(sc.plus("1 + 2")).isEqualTo(3);
    }

    @Test
    @DisplayName("마이너스 테스트")
    void minusTest() {
        assertThat(sc.minus("1 - 2")).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest() {
        assertThat(sc.multiply("10 * 2")).isEqualTo(20);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() throws NotEqualRemainderZeroException {
        assertThat(sc.divide("10 / 2")).isEqualTo(5);
    }

    @Test
    @DisplayName("나눌 때 정수로 떨어지지 않으면 NotEqualRemainderZeroException 예외를 발생시킨다")
    void isEqualRemainderZero() {
        assertThatThrownBy(() -> sc.divide("10 / 3"))
            .isInstanceOf(NotEqualRemainderZeroException.class);
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 실행 결과인 10을 출력하는 테스트")
    void calcTest() throws Exception {
        assertThat(sc.calculate("2 + 3 * 4 / 2")).isEqualTo("10");
    }

    @ParameterizedTest
    @ValueSource(strings = { "\t", "\n", "  \t  \n" })
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfWhiteSpaceOfInputValueTest(String expression) {
        assertThatThrownBy(() -> sc.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfNullOfInputValueTest() {
        assertThatThrownBy(() -> sc.calculate(null))
            .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = { "123+", "!", "1 ! 3", "1 @ 3 & 5 ^ 7 | 9" })
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfNotFourFundamentalOperatorTest(String expression) {
        assertThatThrownBy(() -> sc.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1+2", "1+ 2", "1 +2" })
    @DisplayName("입력 문자열의 숫자와 사칙 연산 사이에 빈 공백 문자열이 없을 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfNotExistSpaceBetweenNumberAndOperator(String expression) {
        assertThatThrownBy(() -> sc.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
