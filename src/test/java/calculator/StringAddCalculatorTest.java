package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @ParameterizedTest(name = "\"{0}\" 값을 입력할 경우 0을 반환해야 한다.")
    @NullAndEmptySource
    void whenEmptyGivenReturnZero(String input) {
        System.out.println("input :" + input);
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"0", "9"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void givenIntString_shouldReturnInt(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.valueOf(input));
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void givenTwoIntWithComma_shouldReturnSum() {
        String input = "1,2";
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    void givenIntCanIncludeCommaAndColon() {
        String input = "1,2:3";
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    public void givenIntCanIncludeCustomDelimiter(){
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 NegativeNumberException 예외가 발생해야 한다.")
    public void givenIntWithNegative_shouldExceptionOccur() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(NegativeNumberException.class)
                .hasMessageContaining("음수값이 입력되었습니다");
    }
}
