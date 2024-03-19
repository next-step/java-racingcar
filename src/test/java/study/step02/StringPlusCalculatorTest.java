package study.step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
 * 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 * 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
 *
 * ** 요구사항 **
 * 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 */
public class StringPlusCalculatorTest {

    @Test
    void givenStringNullThenReturnZero() {
        String givenString = null;
        int result = StringPlusCalculator.splitAndSum(givenString);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void givenStringEmptyThenReturnZero() {
        String givenString = "";
        int result = StringPlusCalculator.splitAndSum(givenString);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void givenOneStringWithCommaDelimiterAddTest() {
        int result = StringPlusCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void givenStringWithCommaDelimiterAddTest() {
        int result = StringPlusCalculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void givenStringWithMixedDelimiterAddTest() {
        int result = StringPlusCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void givenStringWithCustomDelimiterAddTest() {
        int result = StringPlusCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void givenStringWithNegativeNumberReturnRuntimeException() throws Exception {
        assertThatThrownBy(() -> StringPlusCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
