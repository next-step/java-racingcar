package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("스트링 토큰 테스트")
class StringTokenTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("5", toIntArray(5)),
            Arguments.of("1,2", toIntArray(1, 2)),
            Arguments.of("1,2,3", toIntArray(1, 2, 3)),
            Arguments.of("1,2:3", toIntArray(1, 2, 3)),
            Arguments.of("//;\n1;2", toIntArray(1, 2)),
            Arguments.of("//;\n1;2;3", toIntArray(1, 2, 3))
        );
    }

    private static int[] toIntArray(int... n) {
        return n;
    }

    @ParameterizedTest(name = "input={0} / expected={1}")
    @MethodSource("provideArguments")
    @DisplayName("String을 split하여 int 배열로 반환합니다.")
    void toIntArray(String text, int[] expected) {
        int[] actual = StringToken.from(text)
                                  .toIntArray();
        assertThat(actual).isEqualTo(expected);
    }
}
