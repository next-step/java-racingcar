import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringClassTests {

    private static final String COMMA_SPLITTER = ",";

    @DisplayName("요구사항 1. split() 테스트")
    @ParameterizedTest
    @MethodSource("stringSplitByCommaCases")
    public void stringSplitByCommaTest(String input, String[] expected) {
        String[] actual = input.split(COMMA_SPLITTER);
        assertThat(actual).contains(expected);
        assertThat(actual).containsExactly(expected);
    }

    private static Stream<Arguments> stringSplitByCommaCases() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"}),
                Arguments.of("1,", new String[]{"1"}),
                Arguments.of("1,,", new String[]{"1"}),
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of(",", new String[]{}),
                Arguments.of("", new String[]{""})
        );
    }

    @DisplayName("요구사항 2. substring() 테스트")
    @ParameterizedTest
    @CsvSource(value = {"(1,2):1,2", "(3,4):3,4"}, delimiter = ':')
    public void stringSubstringTest(String input, String expected) {
        String actual = input.substring(1,4);
        assertThat(actual).isEqualTo(expected);
    }


}
