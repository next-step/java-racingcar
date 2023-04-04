package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringTest {
    @Test
    void requirement1() {
        // given
        String given1 = "1,2";
        String given2 = "1";

        // when
        String[] result1 = given1.split(",");
        String[] result2 = given2.split(",");

        // then
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void requirement2() {
        // given
        String given = "(1,2)";

        // when
        String result = given.substring(1, given.length()-1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("문자열에 특정 인덱스로 charAt을 하면 해당하는 문자가 반환된다")
    @MethodSource("charAtTestParameter")
    void requirement3(int index, Character expected, Class<Exception> exception) {
        String given = "abc";

        if (exception != null) {
            assertThatThrownBy(() -> given.charAt(index))
                    .isInstanceOf(exception)
                    .hasMessageContaining("index out of range: " + index);
        } else {
            assertThat(given.charAt(index))
                    .isEqualTo(expected);
        }
    }

    static Stream<Arguments> charAtTestParameter() {
        return Stream.of(
                Arguments.of(0, 'a', null),
                Arguments.of(2, 'c', null),
                Arguments.of(-1, null, IndexOutOfBoundsException.class)
        );
    }

}
