import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author jeongheekim
 * @date 3/9/24
 */
public class StringAddCalculatorTest {
    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("빈 문자열 또는 null값을 입력할 경우 0을 반환해야 한다.")
    void splitAndSumNullOrEmptyStringTest(String input) {
        Assertions.assertEquals(StringAddCalculator.splitAndSum(input), 0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSumReturnNumberTest() {
        Assertions.assertEquals(StringAddCalculator.splitAndSum("1"), 1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void whenSplitTwoNumbersReturnNumbersSumTest() {
        Assertions.assertEquals(StringAddCalculator.splitAndSum("1,2"), 3);

    }

    @Test
    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다. (\"1:2\" => 3)")
    void whenOtherSplitNumbersReturnNumbersSumTest() {
        Assertions.assertEquals(StringAddCalculator.splitAndSum("1:2"), 3);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void specificSeperatorSplitNumbersReturnNumbersSumTest() {
        Assertions.assertEquals(StringAddCalculator.splitAndSum("//;\n1;2;3"), 6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생한다.")
    void splitMinusNumbersReturnExceptionTest() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
