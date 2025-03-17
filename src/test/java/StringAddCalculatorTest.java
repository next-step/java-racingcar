import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @Test
    public void calculate_null_또는_빈문자() {
        int result = StringAddCalculator.calculate(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    public void calculate_숫자하나() {
        int result = StringAddCalculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    @Test
    public void calculate_쉼표구분자() {
        int result = StringAddCalculator.calculate("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있음")
    @Test
    public void calculate_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있음")
    @Test
    public void calculate_custom_구분자() {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    @Test
    public void calculate_negative() {
        Assertions.assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}