import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @ParameterizedTest
    @MethodSource("generateSplitData")
    void split(String input, String[] expected) {
        String[] actual = input.split(",");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void subString() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource({"0,a", "1,b", "2,c"})
    @DisplayName("charAt Test")
    void charAt(int index, char expected) {
        char actual = "abc".charAt(index);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt IndexOutofBounds Exception Test")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    static Stream<Arguments> generateSplitData() {
        return Stream.of(
            Arguments.of("1,2", new String[]{"1", "2"}),
            Arguments.of("1", new String[]{"1"})
        );
    }
}
