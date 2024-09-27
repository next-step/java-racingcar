package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2-3", "3:4-7", "5,6:7-18"}, delimiter = '-')
    void 쉼표나_콜론을_구분자로_분리한_숫자의_합을_반환한다(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자_또는_null을_전달하면_0을_반환한다(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1-1", "2,-2", "3:-3", "4,:-4", ",5-5", ":,6-6", ",7,-7"}, delimiter = '-')
    void 숫자_한개는_그대로_반환한다(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @CsvSource(value = {"//@\\n1@2-3", "///\\n3/4-7", "// \n5 6-11", "//#$\n7#$8-15"}, delimiter = '-')
    @DisplayName("//와 \\n 사이의 문자를 커스텀구분자로 사용해 분리한 합을 반환한다.")
    void 커스텀_구분자를_사용할수_있다(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }
}