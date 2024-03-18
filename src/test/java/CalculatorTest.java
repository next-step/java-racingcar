import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;


@DisplayName("문자열 계산기")
public class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void inputIsNullOrEmptyShouldReturnZero(String value) {
        int result = Calculator.calculate(value);
        assertThat(result).isEqualTo(0);
    }


    @Test
    @DisplayName("입력 문자열이 숫자 하나이면 해당 숫자를 반환한다")
    public void inputHasOnlyOneNumberShouldReturnTheNumber() {
        int result = Calculator.calculate("5");
        assertThat(result).isEqualTo(5);

    }


    @Test
    @DisplayName("입력 문자열을 쉼표(,) 구분자로 분리하고 합을 반환한다")
    public void splitInput_delimiterIsComma() {
        String input = "1,2,3";

        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(6);
    }


    @Test
    @DisplayName("입력 문자열을 쉼표(:) 구분자로 분리하고 합을 반환한다")
    public void splitInput_delimiterIsColon() {
        String input = "1:2:3";

        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(6);
    }


    @Test
    @DisplayName("입력 문자열을 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 분리하고 합을 반환한다")
    public void splitInput_delimiterIsCustom() {
        String input = "//k\n1k2k3";

        int result = Calculator.calculate(input);

        assertThat(result).isEqualTo(6);
    }


    @Test
    @DisplayName("음수 문자열이 입력될 경우 RuntimeException 발생한다")
    public void negativeNumberShouldThrowRuntimeException() {
        String input = "-1:2:3";

        Assertions.assertThrows(RuntimeException.class, () -> Calculator.calculate(input));
    }


}
