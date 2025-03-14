import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @Description("빈 문자열을 입력할 경우 0을 반환")
    void splitAndSum_Empty() {
        int result = Calculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @Description("쉼표(,)구분자를 가지는 경우 각 숫자를 더한 값을 반환")
    void splitAndSum_CommaDelimiter() {
        int result = Calculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @Description("콜론(:)구분자를 가지는 경우 각 숫자를 더한 값을 반환")
    void splitAndSum_ColonDelimiter() {
        int result = Calculator.splitAndSum("1:2:3");
        assertThat(result).isEqualTo(6);
    }


    @Test
    @Description("//와 \n 사이에 위치하는 문자를 가지는 경우 해당 문자를 구분자로 사용하여 각 숫자를 더한 값 반환")
    void splitAndSum_CustomDelimiter() {
        int result = Calculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @Description("음수가 입력되면 RuntimeException 발생")
    void splitAndSum_Negative() {
        assertThatThrownBy(() -> {
            Calculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }
}
