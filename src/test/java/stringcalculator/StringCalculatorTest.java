package stringcalculator;

import com.sun.codemodel.internal.JExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    /*
     구현 목적 : 사용자가 입력한 문자열 값 따라 사칙연산 수행
     요구 사항
        1. 입력 문자열의 '숫자' 와 '사칙연산' 사이 반드시, 빈 공백 문자열
        2. 나눗셈: 결과 값 정수로 떨어지는 값으로 한정
        3. 입력값에 따라 계산 순서 결정
            (ex: input"2 + 3 * 4 / 2"  return 10)
     클린 코드
        1. 단위 테스트 (각 사칙연산, 입력값 null, 사칙연산 기호 불일치 등)
        2. 메소드 분리 노력

     */

    //******** 계획 : custom Exception message 관리 및 테스트 케이스 추가 *************//
    //******** 심화 : JUnit Parameterized Test & Custom Exception github 확인 ******//

    @DisplayName("입력값 공백 문자 테스트")
    @ParameterizedTest
    @ValueSource(strings = "")
    public void null_or_emptystring (String emptyString){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator(emptyString);
            stringCalculator.calculate();
        });
    }

    @DisplayName("지정 문자열 외 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 [ 2", "5 % 1", " ^ 6", " 3     * 2"})
    public void not_calculable_symbol (String expression){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator(expression);
            stringCalculator.calculate();
        });
    }

    @DisplayName("나눗셈 0으로 나눌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4 / 0", "0 / 0"})
    public void divide_by_zero (String expression){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator(expression);
            stringCalculator.calculate();
        });
    }

    @DisplayName("사칙연산 기능 테스트")
    @Test
    public void featureTest () {
        //after test -> refactor : plus, minus, multi
        String expression = "3 + 4 - 2 * 3";
        StringCalculator fullscal = new StringCalculator(expression);

        assertThat(fullscal.calculate()).isEqualTo(15);
    }

    @DisplayName("덧셈 기능 테스트")
    @Test
    public void StringAndPlus () {
        String expression = "1 + 1";
        StringCalculator scal = new StringCalculator(expression);

        assertThat(scal.calculate()).isEqualTo(2);
    }

    @DisplayName("곱셈 기능 테스트")
    @Test
    public void StringAndMultipler (){
        String expression = "2 * 2";
        StringCalculator scal = new StringCalculator(expression);

        assertThat(scal.calculate()).isEqualTo(4);
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    public void StringAndMinus (){
        String expression = "10 - 3";
        StringCalculator scal = new StringCalculator(expression);

        assertThat(scal.calculate()).isEqualTo(7);
    }

    @DisplayName("나눗셈 기능 테스트")
    @Test
    public void StringAndDivider (){
        String expression = "10 / 5";
        StringCalculator scal = new StringCalculator(expression);

        assertThat(scal.calculate()).isEqualTo(2);
    }




}
