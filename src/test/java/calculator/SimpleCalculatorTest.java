package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleCalculatorTest {
    SimpleCalculator sc = new SimpleCalculator();

    @Test
    @DisplayName("더하기 테스트")
    void plusTest() {
        assertThat(sc.plus("1 + 2")).isEqualTo("3");
    }

    @Test
    @DisplayName("마이너스 테스트")
    void minusTest() {
        assertThat(sc.minus("1 - 2")).isEqualTo("-1");
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest() {
        assertThat(sc.multiply("10 * 2")).isEqualTo("20");
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() throws NotEqualRemainderZero {
        assertThat(sc.divide("10 / 2")).isEqualTo("5");
    }

    @Test
    @DisplayName("나눗셈의 경우 결과 값을 정수로 떨어지는 값인지 테스트")
    void isEqualRemainderZero() {
        assertThatThrownBy(() -> sc.divide("10 / 3"))
            .isInstanceOf(NotEqualRemainderZero.class);
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 실행 결과인 10을 출력하는 테스트")
    void calcTest() throws Exception {
        assertThat(sc.calc("2 + 3 * 4 / 2")).isEqualTo("10");
    }

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfNullOrWhiteSpaceOfInputValueTest() {
        assertThatThrownBy(() -> sc.calc(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("\t"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("\n"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("         \t           \n"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfNotFourFundamentalOperatorTest() throws Exception {
        assertThatThrownBy(() -> sc.calc("123+"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("!"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("1 ! 3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("1 @ 3 & 5 ^ 7 | 9"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 문자열의 숫자와 사칙 연산 사이에 빈 공백 문자열이 없을 경우 IllegalArgumentException throw 테스트")
    void throwIllegalArgumentExceptionIfNotExistSpaceBetweenNumberAndOperator() throws Exception {
        assertThatThrownBy(() -> sc.calc("1+2"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("1+ 2"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sc.calc("1 +2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
