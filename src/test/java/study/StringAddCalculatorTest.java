package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/*
TDD가 막막한 이유는 요구사항을 제대로 파악하지 못하고 쪼개지 못했기 때문이다.
1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

=> 요구사항 최대한 쪼개어 Test Case로 만들기
*/

public class StringAddCalculatorTest {

    //Test Case
    //1. "", null => 0으로 반환
    @Test
    void Empty() {
        assertThat(Calculator.SplitSum(null)).isEqualTo(0);
        assertThat(Calculator.SplitSum("")).isEqualTo(0);
    }

    //2. 배열로 들어왔을 때 쉼표로 구분하여 숫자 더하기
    @Test
    void Array() {
        assertThat(Calculator.SplitSum("1,2")).isEqualTo(3);
        assertThat(Calculator.SplitSum("1,2,3")).isEqualTo(6);
    }

    //3. 쉼표와 숫자하나 들어왔을 때 숫자 반환하기
    @Test
    void NumberComma() {
        assertThat(Calculator.SplitSum("1,")).isEqualTo(1);
    }

    //4. ,:로 들어왔을 때 구분하여 숫자더하기
    @Test
    void SplitAdd() {
        assertThat(Calculator.SplitSum("1,2:3")).isEqualTo(6);
    }

    //5. //, /n일 때도 문자 구분해서 커스텀구분자로 사용하기 ex)“//;\n1;2;3” => 6
    @Test
    void CumstomSplit() {
        assertThat(Calculator.SplitSum("//;\n1;2;3")).isEqualTo(6);
    }

    //6. 음수를 전달할 때, 숫자 이외의 값이 들어오는 경우 RuntimeException 예외 throw해야한다.
    @Test
    void exceptionNegative() {
        assertThatThrownBy(() -> { Calculator.SplitSum("-1:2:3");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("RuntimeException");

    }
}
