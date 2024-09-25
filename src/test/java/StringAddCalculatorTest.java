import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(final String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "3,3", "99,99"})
    public void splitAndSum_숫자하나(final String input, final int excepted) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2;3", "9,9;18"}, delimiter = ';')
    public void splitAndSum_쉼표구분자(final String input, final int excepted) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6", "5,5:4;14"}, delimiter = ';')
    public void splitAndSum_쉼표_또는_콜론_구분자(final String input, final int excepted) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(excepted);
    }

    @ParameterizedTest
    @MethodSource
    public void splitAndSum_custom_구분자(final String input, final int excepted) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(excepted);
    }

    public static Stream<Arguments> splitAndSum_custom_구분자() {
        return Stream.of(
            Arguments.of("//;\n1;2;3", 6),
            Arguments.of("//.\n1.2.3", 6),
            Arguments.of("//@\n1@2@3", 6),
            Arguments.of("//[\n1[2[3", 6)
        );
    }

    @ParameterizedTest
    @MethodSource
    public void splitAndSum_custom_구분자_여러개(final String input, final int excepted) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(excepted);
    }

    public static Stream<Arguments> splitAndSum_custom_구분자_여러개() {
        return Stream.of(
            Arguments.of("//;\n//.\n1;2.3", 6),
            Arguments.of("//@\n//[\n//*\n1@2[3*4", 10)
        );
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}