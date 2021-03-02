package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringTest {

    @Test
    @DisplayName("1,2 를 , 로 split 했을 때 잘 분리되는지 확인")
    void split1() {
        String str = "1,2";
        String[] result = str.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1 을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split2() {
        String str = "1";
        String[] result = str.split(",");

        assertThat(result).contains("1");
        assertEquals(1, result.length);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 substring() 메소드를 활용해 ()을 제거하고 1,2 를 반환하는지 확인")
    void subString() {
        String str = "(1,2)";
        String substring = str.substring(1, 4);

        assertEquals("1,2", substring);
    }

    @ParameterizedTest
    @MethodSource("parametersByCharAt")
    @DisplayName("abc 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void charAt(char expectedChar, int index) {
        String str = "abc";

        assertEquals(expectedChar, str.charAt(index));
    }

    private static Stream<Arguments> parametersByCharAt() {
        return Stream.of(
            Arguments.of('a', 0),
            Arguments.of('b', 1),
            Arguments.of('c', 2)
        );
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 IndexOutOfBoundsException 이 발생 하는지 확인")
    void chatAtThrowIndexOutOfBoundsException() {
        String str = "adc";

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

}
