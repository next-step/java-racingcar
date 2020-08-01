package stringcalculator.stringcalculator;

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

    // 문자열 입력값



    @Test
    public void StringAndPlus (){
        String equation = "1+1";
        double result = StringCalculator.calculate(equation);
        assertThat(result).isEqualTo(2.0);
    }
    @Test
    public void null_or_emptystring (){
        assertThatIllegalArgumentException().isThrownBy(()->{

        });
    }

    @Test
    public void not_calculable_symbol (){
        assertThatIllegalArgumentException().isThrownBy(()->{});
    }

    @Test
    public void split_add_test(){
        int result1 = scal.split_add("1 c 2");
        assertThat(result1).isEqualTo(3);
    }

    @Test
    public void split_substract(){
        assertThat("").isEqualTo(0);
    }

    @Test
    public void split_multiple(){
        assertThat("").isEqualTo(0);
    }

    @Test
    public void split_divide(){
        assertThat("").isEqualTo(0);
    }

    //사칙 연산 모두 포함 기능 구현 후 테스트?
}
