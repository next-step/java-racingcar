package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    void split1() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void subString() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 Test")
    @MethodSource("stringAndIndex")
    void charAt1(String input, int index) {
        char charAt = "abc".charAt(index);
        assertThat(charAt).isEqualTo(input);
    }

    public static Stream<Arguments> stringAndIndex() {
        return Stream.of(
                Arguments.of("a", 0),
                Arguments.of("b", 1),
                Arguments.of("c", 2)
        );
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값 벗어났을 때 Exception Test")
    void charAt2() {
        int charLength = "abc".length();
        assertThatThrownBy(() -> {
            "abc".charAt(charLength+1);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range");
    }
}
