package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * 요구 사항 1
     */
    @ParameterizedTest
    @MethodSource("generateParameters")
    void splitTest(String given, List<String> results) {
        String[] splitResult = given.split(",");
        assertThat(splitResult).containsExactlyInAnyOrderElementsOf(results);
    }

    static Stream<Arguments> generateParameters() {
        return Stream.of(
                Arguments.of("1,2", Arrays.asList("1", "2")),
                Arguments.of("1", List.of("1"))
        );
    }

    /**
     * 요구 사항 2
     */
    @Test
    void substringTest() {
        String given = "(1,2)";

        String withoutBracket = given.substring(1, 4);

        assertThat(withoutBracket).isEqualTo("1,2");
    }

    /**
     * 요구 사항 3
     */
    @DisplayName("특정 위치 문자를 가져오는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAtTest(Integer index, Character expectedChar) {
        String given = "abc";

        char charAt = given.charAt(index);

        assertThat(charAt).isEqualTo(expectedChar);
    }

    @Test
    @DisplayName("특정 위치 문자를 가져올 때 위치 값을 벗어날 경우, StringIndexOutOfBoundsException 발생")
    void charAtExceptionTest() {
        int index = 3;
        assertThatThrownBy(() -> {
            String given = "abc";
            char chatAt0 = given.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("out of range: " + index);
    }
}
