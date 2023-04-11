package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @ParameterizedTest(name = "{0}에 음수가 있으므로 RuntimeException이 발생한다")
    @ValueSource(strings = {"-1,2:3", "1,-2:3", "1,2:-3"})
    void 음수를_전달할_경우_RuntimeException이_발생한다(String input) {
        assertThatThrownBy(() -> splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "{0}에 정의된 구분자로 구분된 숫자들을 더하면 {1}이다")
    @MethodSource("getCustomDelimiterStubs")
    void 커스텀_구분자를_지정할_수_있다(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    static Stream<Arguments> getCustomDelimiterStubs() {
        return Stream.of(
            Arguments.arguments("//;\n1;2;3", 6),
            Arguments.arguments("//@\n2@3@4", 9),
            Arguments.arguments("//~\n3~4~5", 12)
        );
    }

    @ParameterizedTest(name = "컴마와 콜론이 포함된 {0}의 숫자들을 더하면 {1}이다")
    @CsvSource(value = {"1,2:3/6", "2:3,4/9"}, delimiter = '/')
    void 컴마와_콜론으로_구분된_숫자들을_더한_값을_반환한다(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "컴마로 구분된 {0}의 숫자들을 더하면 {1}이다")
    @CsvSource(value = {"1,2,3/6", "2,3/5"}, delimiter = '/')
    void 컴마로_구분된_숫자들을_더한_값을_반환한다(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "문자열 {0}을 입력하면 그대로 숫자 {1}이 반환된다")
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void 숫자_하나를_넣으면_그대로_반환한다(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @Test
    void null을_입력하면_0을_반환한다() {
        assertThat(splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void 빈_문자열을_입력하면_0을_반환한다() {
        assertThat(splitAndSum("")).isEqualTo(0);
    }

    // 이하는 요구사항에 첨부된 TestCase 소스 코드입니다.
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
