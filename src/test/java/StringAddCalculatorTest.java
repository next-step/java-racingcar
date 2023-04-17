import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    public void returnZeroFromBlankAndNullValue() {
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @Test
    public void returnIntegerFromStringFormatInteger() {
        String input = "1";
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @Test
    public void splitAndSumTwoNumber() {
        String input = "1,2";
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(3);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    public void splitByLikeColonToo() {
        String input = "1,2:3";
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @DisplayName("문자 사이에 커스텀 문자열을 지정할 수 있다.")
    @Test
    public void splitByCustomDelimiter() {
        String input = "//;\n1;2;3";
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @DisplayName("음수가 하나라도 포함되어 있다면 RunTimeException 예외가 발생해야 한다.")
    @Test
    public void causeRunTimeException_whenContainNegative() {
        String input = "-1,2,3";
        Assertions.assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 이외의 값이 들어가게 되더라도 RuntimeException 예외가 발생해야 한다.")
    @Test
    public void causeRunTimeException_whenNonNumbericValue() {
        String input = "=,-,@";
        Assertions.assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}