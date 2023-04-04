package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringAddCalculatorTest {


    @DisplayName("빈 문자열 값을 입력 할 경우 0을 반환한다")
    @Test
    void givenEmptyStringWhenInputReturnZero() {
        // given
        String text = "";

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null 값을 입력 할 경우 0을 반환한다")
    @Test
    void givenNullWhenInputReturnZero() {
        // given
        String text = null;

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @Test
    void givenOneNumberStringWhenInputReturnNumber() {
        // given
        String text = "1";

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @Test
    void givenTwoNumberStringWithCommaWhenInputReturnSum() {
        // given
        String text = "1,2";

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다")
    @Test
    void givenTwoNumberStringWithColonWhenInputReturnSum() {
        // given
        String text = "1:2";

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("구분자를 쉼표(,) 와 콜론(:)을 같이 사용 할 수 있다")
    @Test
    void givenTwoNumberStringWithCommaAndColonWhenInputReturnSum() {
        // given
        String text = "1,2:3,4";

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("// 와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @Test
    void givenCustomDelimiterWhenInputReturnSum() {
        // given
        String text = "//;\n1;2;3";

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외를 발생시킨다")
    @Test
    void givenNotNumberStringWhenInputReturnRuntimeException() {
        // given
        String text = "-1,-2,3,4,5,6,7,8,9,10,11";

        // when & then
        Assertions.assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
