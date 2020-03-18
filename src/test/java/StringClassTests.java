import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringClassTests {

    private static final String COMMA_SPLITTER = ",";
    private static final String EXPECTED_INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_PATTERN = "String index out of range: \\d*";

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
        String actual = input.substring(1, 4);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("요구사항 3. charAt() 테스트. 정상 케이스")
    @ParameterizedTest
    @CsvSource(value = {"abc:2:c", "paul:0:p", "tdd:1:d"}, delimiter = ':')
    public void stringCharAtMethodWithNormalCaseTest(String input, int targetIndex, char expected) {
        char actual = input.charAt(targetIndex);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("요구사항 3. charAt() 테스트. 예외 발생 케이스")
    @ParameterizedTest
    @CsvSource(value = {"abc:3", "paul:8", "tdd:315"}, delimiter = ':')
    public void stringCharAtMethodWithExceptionCaseTest(String input, int targetIndex) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(targetIndex))
                .withMessageMatching(EXPECTED_INDEX_OUT_OF_BOUNDS_EXCEPTION_MESSAGE_PATTERN);
    }

}
