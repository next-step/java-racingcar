package racingcar.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created : 2020-10-29 오후 1:09
 * Developer : Seo
 * Description : 문자열 사칙 연산 계산기 구현
 * Points :
 *   1. 이번 미션의 핵심은 내가 구현하는 코드에 단위 테스트를 추가하는 경험을 하는 것이다.
 *   2. 모든 예외 상황을 처리하기 위해 너무 복잡하게 접근하지 않아도 된다.
 *   3. 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 * Requirements :
 *   1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 *   2. 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 *   3. 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 *   4. 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
 *      즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 *   5. 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
class StringCalculatorTest {

    StringCalculator sCal = null;

    @BeforeEach
    void setUp() {
        sCal = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("덧셈")
    @CsvSource(value = {"1:1"}, delimiter = ':')
    void givenString_thenPlus(String s1, String s2) {
        assertThat(sCal.plus(s1, s2)).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("뺄셈")
    @CsvSource(value = {"1:1"}, delimiter = ':')
    void givenString_thenMinus(String s1, String s2) {
        assertThat(sCal.minus(s1, s2)).isZero();
    }

    @ParameterizedTest
    @DisplayName("곱셈")
    @CsvSource(value = {"1:1"}, delimiter = ':')
    void givenString_thenMultiply(String s1, String s2) {
        assertThat(sCal.multiply(s1, s2)).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("나눗셈")
    @CsvSource(value = {"1:1"}, delimiter = ':')
    void givenString_thenDivide(String s1, String s2) {
        assertThat(sCal.divide(s1, s2)).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("입력 값이 null 이거나 빈 공백 문자")
    @CsvSource(value = {"null: "}, delimiter = ':')
    void givenNull_thenThrowException(String s1, String s2) {
        assertThatIllegalArgumentException().isThrownBy(() -> sCal.divide(s1, s2));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호 정규식")
    @ValueSource(strings = {"+", "-", "*", "/"})
    void givenOperator_thenCheckPattern(String s) {
        assertTrue(sCal.isOperator(s));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우")
    @ValueSource(strings = {"!", "@", "#", "$", "%"})
    void givenNoOperator_thenThrowException(String s) {
        assertThatIllegalArgumentException().isThrownBy(() -> sCal.isOperator(s));
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 경우")
    @ValueSource(strings = {"2 + i * 4 / 2 - 1"})
    void givenNoNumber_thenThrowException(String s) {
        assertThatIllegalArgumentException().isThrownBy(() -> sCal.isNumeric(s));
    }

    @ParameterizedTest
    @DisplayName("사칙 연산을 모두 포함하는 기능")
    @ValueSource(strings = {"2 + 3 * 4 / 2 - 1"})
    void givenString_thenOperate(String s) {
        assertThat(sCal.calculate(s)).isEqualTo(9);
    }


}
