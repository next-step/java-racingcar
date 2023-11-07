package calculator;

import org.junit.jupiter.api.Test;

import static calculator.Calculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest
{
    // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
    @Test
    void null_빈문자열_값()
    {
        assertThat(cal(null)).isEqualTo(0);
        assertThat(cal("")).isEqualTo(0);
    }

    // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
    @Test
    void 숫자_하나()
    {
        assertThat(cal("1")).isEqualTo(1);
    }

    // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
    @Test
    void 콤마_구분자()
    {
        assertThat(cal("1,2,3")).isEqualTo(6);
    }

    // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
    @Test
    void 콜론_구분자()
    {
        assertThat(cal("1:2:3")).isEqualTo(6);
    }

    // 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
    @Test
    void 커스텀_구분자()
    {
        assertThat(cal("//;\n1;2;3")).isEqualTo(6);
    }

    // 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
    @Test
    void 음수()
    {
        assertThatThrownBy(()->cal("-1,2,3")).isInstanceOf(RuntimeException.class);
    }
}
