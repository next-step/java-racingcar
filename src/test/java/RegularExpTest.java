import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RegularExpTest {


    @ParameterizedTest
    @ValueSource(strings = {"!!!]]", "^$&^#"})
    void specialSymbolTest(String input) {
        assertThat(input.matches(".*[\\. \\[ \\] \\ \\{ \\} \\* \\+ \\? \\^ \\$ \\( \\) \\|]*.*$")).isTrue();
    }

    @ParameterizedTest
    @MethodSource(value = "generatePatternMatcherResult")
    void matcherGroupTest(Pattern pattern, String input, boolean expected1, int expected2) {

        Matcher matcher = pattern.matcher(input);
        assertThat(matcher.find()).isEqualTo(expected1);
        assertThat(matcher.groupCount()).isEqualTo(expected2);
    }

    private static Stream<Arguments> generatePatternMatcherResult() {
        return Stream.of(
                Arguments.of(Pattern.compile("//(.*)\n"), "//@\n123123", true, 1),
                Arguments.of(Pattern.compile("//(.*)\n(.*)"), "//;\n1:2:4", true, 2)
        );
    }
    @ParameterizedTest
    @MethodSource(value = "generateInputAndRegex")
    void matchesWithRegularExpTest(String input, String regex) {
        assertThat(input.matches(regex)).isTrue();
    }

    private static Stream<Arguments> generateInputAndRegex() {
        return Stream.of(
                Arguments.of("\n", "\n"),
                Arguments.of("//@\n123123", "//.+\n.+"),
                Arguments.of("123\n123123", ".+\n.+"),
                Arguments.of("123\n", ".+\\n")
        );
    }

    @Test
    void splitWithRegularExpTest() {
        String[] actual = "@\n123123".split("\n");
        assertThat(actual).hasSize(2);
        assertThat(actual).containsExactly("@", "123123");
    }
}