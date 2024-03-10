package calculator;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환 (예: \"\" => 0)")
    public void nullValue(){
        Assertions.assertThat(Calculator.sum("")).isEqualTo(0);
        Assertions.assertThat(Calculator.sum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: \"1,2\" => 3)")
    public void commaValue(){

    }

    @Test
    @DisplayName("콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: \"1:2\" => 3)")
    public void colonValue(){

    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: \"1,2:3\" => 6)")
    public void commaColonValue(){

    }

    @Test
    @DisplayName("앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. (예: “//;\\n1;2;3” => 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6)")
    public void customDelimiterValue(){

    }

    @Test
    @DisplayName("문자열 계산기에 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw")
    public void noNumber(){

    }

    @Test
    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외를 throw")
    public void negativeNumber(){

    }
}
