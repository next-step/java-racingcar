package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @ParameterizedTest(name = "구분자를 기준으로 문자열을 분할 할 수 있다.")
    @MethodSource("provideSplitArguments")
    public void splitTest(String input, String delimiter, String[] expectedResults) {
        assertThat(input.split(delimiter))
                .containsExactly(expectedResults);
    }

    private static Stream<Arguments> provideSplitArguments() {
        return Stream.of(
                Arguments.of("1,2", ",", new String[] {"1", "2"}),
                Arguments.of("1", ",", new String[] {"1"})
        );
    }

    @DisplayName("부분 문자열을 만들 수 있다.")
    @Test
    public void substringTest() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때, 문자 위치 값을 벗어나면 예외가 발생한다.")
    @Test
    public void indexOutOfBoundsExceptionTest() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }

}
