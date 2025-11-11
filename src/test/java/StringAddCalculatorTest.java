import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열이나_null일_경우에는_0을_반환한다(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void 숫자_하나를_문자열로_입력한_경우에는_해당_숫자를_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,5:7", "20,30:50"}, delimiter = ':')
    void 숫자_두개를_콤마로_구분해서_입력할_경우_두_숫자의_합을_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6", "2:5;7", "20,30:40;90"}, delimiter = ';')
    void 콤마와_콜론을_구분자로_사용한_문자열의_합을_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }

    @ParameterizedTest
    @MethodSource("커스텀_구분자가_존재하는_경우")
    void 커스텀_구분자가_존재할_때_문자열의_합을_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }

    private static Stream<Arguments> 커스텀_구분자가_존재하는_경우() {
        return Stream.of(
                Arguments.of("//!\n1!2!3", 6),
                Arguments.of("//@\n5@6@7", 18),
                Arguments.of("//&\n20&30&40", 90)
        );
    }

    @ParameterizedTest
    @MethodSource("커스텀_구분자와_기본_구분자가_같이_존재하는_경우")
    void 커스텀_구분자와_기본_구분자가_같이_존재할_때_문자열의_합을_반환한다(String input, int sum) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(sum);
    }

    private static Stream<Arguments> 커스텀_구분자와_기본_구분자가_같이_존재하는_경우() {
        return Stream.of(
                Arguments.of("//[\n1[2,3", 6),
                Arguments.of("//@\n5@6:7", 18),
                Arguments.of("//&\n20&30:40,50", 140)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,1,3", "2,-1,10", "3,4,-100"})
    void 음수가_포함되어_있다면_예외가_발생한다(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 포함되었습니다.");
    }
}
