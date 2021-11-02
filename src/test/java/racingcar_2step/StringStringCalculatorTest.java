package racingcar_2step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar_2step.operation.*;

import static org.assertj.core.api.Assertions.*;

public class StringStringCalculatorTest {

    /**
     *  1. Calculator 클래스
     *      - calculate 계산
     *  2. Operation 인터페이스
     *      - Sum, Minus, Multiply, Divide 클래스 구현
     *      - Operations : Operation 을 담고 있는 클래스
     *  3. Validation 클래스
     *      - 정수 나누기 체크
     *      - 빈값 or null 체크
     *      - 사칙연산 기호 체크
     *  4. util 클래스
     *      - 문자열 자른 후 스트링 배열변환
     *      - stack 만들고 값 넣기
     */

    @Test
    @DisplayName("문자열 쪼개서 배열로 반환")
    void blankSplit() {
        String[] strings = CalculatorUtil.blankSplit("2 + 3");
        assertThat(strings).containsExactly("2", "+", "3");
    }

    @Test
    @DisplayName("덧셈")
    void sum() {
        Operation operation = new Sum("2", "3");
        assertThat(operation.operate()).isEqualTo("5");
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        Operation operation= new Minus("2", "3");
        assertThat(operation.operate()).isEqualTo("-1");
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        Operation operation = new Multiply("2", "3");
        assertThat(operation.operate()).isEqualTo("6");
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        Operation operation = new Divide("4", "2");
        assertThat(operation.operate()).isEqualTo("2");
    }

    @DisplayName("정수 나누기 검증")
    @Test
    void divideCheck() {
        String[] strArr =  CalculatorUtil.blankSplit("2 +   1");
        assertThatThrownBy(() -> {
            CalculatorValidation.divideCheck(3, 2);
        }).isInstanceOf(IllegalArgumentException.class);
        // 입력값이 정상
        assertThatCode(() -> {
            CalculatorValidation.divideCheck(4, 2);
        }).doesNotThrowAnyException();
    }

    @DisplayName("입력값이 null or 빈 공백인지 검중")
    @Test
    void nullOrBlank() {
        String[] strArr =  CalculatorUtil.blankSplit("2 +   1");
        assertThatThrownBy(() -> {
            CalculatorValidation.nullOrBlankCheck(strArr);
        }).isInstanceOf(IllegalArgumentException.class);
        // 입력값이 정상
        assertThatCode(() -> {
            CalculatorValidation.nullOrBlankCheck( CalculatorUtil.blankSplit("2 + 3"));
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 사친연산인지 검증")
    void arithmeticCheck() {
        String[] strings =  CalculatorUtil.blankSplit("2 & 3");
        assertThatThrownBy(() -> {
            CalculatorValidation.arithmeticCheck(strings);
        }).isInstanceOf(IllegalArgumentException.class);
        // 입력값이 정상
        assertThatCode(() -> {
            CalculatorValidation.nullOrBlankCheck(CalculatorUtil.blankSplit("2 * 3"));
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("문자열 사칙연산 계산")
    void calculate1() {
        String[] strings = CalculatorUtil.blankSplit("2 + 3");
        CalculatorValidation.integratedCheck(strings);
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate(strings)).isEqualTo("5");
    }
    @Test
    @DisplayName("문자열 사칙연산 계산")
    void calculate2() {
        String[] strings = CalculatorUtil.blankSplit("2 + 3 * 4 / 2");
        CalculatorValidation.integratedCheck(strings);
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate(strings)).isEqualTo("10");
    }

}
