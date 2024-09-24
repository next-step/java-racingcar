import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @ParameterizedTest
    @MethodSource("provideStringsForSplit")
    @DisplayName("문자열을 분리하여 배열을 반환한다.")
    void split(String input, String[] expected) {
        String[] actual = input.split(",");

        assertThat(actual).containsExactly(expected);
    }

    private static Stream<Arguments> provideStringsForSplit() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @Test
    @DisplayName("문자열을 인덱스 범위를 기준으로 잘라서 반환한다.")
    void substring() {
        String str = "(1,2)";

        String actual = str.substring(1, 4);

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("지정한 인덱스에 위치한 문자를 반환한다.")
    void charAt() {
        String str = "abc";

        Character actual = str.charAt(0);

        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("지정한 인덱스에 위치한 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void chartAtException() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(7)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
