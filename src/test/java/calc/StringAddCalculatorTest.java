package calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    /**
     1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
     2. 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
     3. 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     * */
    @Test
    void 숫자하나() {
        assertThat(stringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표가_포함() {
        assertThat(stringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_포함() {
        assertThat(stringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_지정() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수인_경우() {
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum("3,-1");
        }).isInstanceOf(RuntimeException.class);
    }


}
