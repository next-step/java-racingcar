package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.Test;
import stringcalculator.util.StringCalculator;
import study.StringsForTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {
    /*
     구현 목적 : 사용자가 입력한 문자열 값 따라 사칙연산 수행
     요구 사항
        1. 입력 문자열의 '숫자' 와 '사칙연산' 사이 반드시, 빈 공백 문자열
        2. 나눗셈: 결과 값 정수로 떨어지는 값으로 한정
        3. 입력값에 따라 계산 순서 결정

     클린 코드
        1. 단위 테스트 (각 사칙연산, 입력값 null, 사칙연산 기호 불일치 등)
        2. 메소드 분리 노력

     */

    //** 계획 : custom Exception message 관리 및 테스트 케이스 추가 *************//
    //**  심화 : JUnit Parameterized Test & Custom Exception github 확인 ******//

    //FINAL : stringCalculator 변수선언 불필요,@EmptySource로 변경 (08.02)
    @DisplayName("입력값 공백 문자 테스트")
    @ParameterizedTest
    @EmptySource
    public void null_or_emptystring(String expression){
        assertThatThrownBy(() ->
                StringCalculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INPUT_VALUE_IS_EMPTY);
    }

    //** 심화 : enum 변경에 따른  테스트 오류: StringCalOperatorTest.java로 이동->*****//
    /*
    @DisplayName("지정 문자열 외 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 [ 2", "5 % 1", " ^ 6", " 3     * 2"})
    public void not_calculable_symbol (String expression) {
        assertThatThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator(expression);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Constants.WRONG_OPERATOR_SYMBOL);
    }

    @DisplayName("나눗셈 0으로 나눌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 / 0", "0 / 0"})
    public void divide_by_zero (String expression){
        assertThatThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator(expression);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.DIVIDE_BY_ZERO);
    }
    */

    @DisplayName("사칙연산 기능 테스트")
    @Test
    public void featureTest () {
        String expression = "3 + 4 - 2 * 3";
        assertThat(StringCalculator.calculate(expression)).isEqualTo(15);
    }

    @DisplayName("덧셈 기능 테스트")
    @Test
    public void StringAndPlus () {
        String expression = "1 + 1";
        assertThat(StringCalculator.calculate(expression)).isEqualTo(2);
    }

    @DisplayName("곱셈 기능 테스트")
    @Test
    public void StringAndMultipler (){
        String expression = "2 * 2";
        assertThat(StringCalculator.calculate(expression)).isEqualTo(4);
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    public void StringAndMinus (){
        String expression = "10 - 3";
        assertThat(StringCalculator.calculate(expression)).isEqualTo(7);
    }

    @DisplayName("나눗셈 기능 테스트 (0으로 나누는 경우는 OperatorTest)")
    @Test
    public void StringAndDivider (){
        String expression = "10 / 5";
        assertThat(StringCalculator.calculate(expression)).isEqualTo(2);
    }

}
