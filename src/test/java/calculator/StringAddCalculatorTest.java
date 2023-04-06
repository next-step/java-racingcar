package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 덧셈 계산기 테스트")
public class StringAddCalculatorTest {

    @DisplayName("빈 문자열과 null 을 입력하면 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource()
    @ValueSource(strings = {" "})
    void givenEmptyStringOrNullWhenInputReturnZero(String input) {
        Number number = new Number(input);

        int result = StringAddCalculator.sumNumbers(number);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1=1", "19=19", "2023=2023"}, delimiter = '=')
    void givenOneNumberStringWhenInputReturnNumber(String input, Integer expected) {
        Number number = new Number(input);

        int result = StringAddCalculator.sumNumbers(number);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"3,4=7", "1,2,3,6=12", "3,5,7,1,12=28"}, delimiter = '=')
    void givenTwoNumberStringWithCommaWhenInputReturnSum(String input, Integer expected) {
        Number number = new Number(input);

        int result = StringAddCalculator.sumNumbers(number);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"3:4=7", "1:2:3:6=12", "3:5:7:1:12=28"}, delimiter = '=')
    void givenTwoNumberStringWithColonWhenInputReturnSum(String input, Integer expected) {
        Number number = new Number(input);

        int result = StringAddCalculator.sumNumbers(number);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구분자를 쉼표(,) 와 콜론(:)을 같이 사용 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "3,4:5=12"}, delimiter = '=')
    void givenTwoNumberStringWithCommaAndColonWhenInputReturnSum(String input, Integer expected) {
        Number number = new Number(input);

        int result = StringAddCalculator.sumNumbers(number);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("// 와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void givenCustomDelimiterWhenInputReturnSum() {
        Number number = new Number("//;\n1;2;3");

        int result = StringAddCalculator.sumNumbers(number);

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외를 발생시킨다")
    @Test
    void givenNotNumberStringWhenInputReturnRuntimeException() {
        Number number = new Number("-1,-9:3,4:5,Z,@");

        Assertions.assertThatThrownBy(() -> StringAddCalculator.sumNumbers(number))
                .isInstanceOf(RuntimeException.class);
    }
}
