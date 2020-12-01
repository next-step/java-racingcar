package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("요구사항 1")
    @ParameterizedTest(name = "\"{0}\"을 ,로 split 했을 때 {1}로 잘 분리되는지 확인")
    @MethodSource("provideStringForSplit")
    void split(String input, String[] expected) {
        String[] result = input.split(",");
        assertThat(result)
                .contains(expected)
                .containsExactly(expected);
    }

    private static Stream<Arguments> provideStringForSplit() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @DisplayName("요구사항 2")
    @ParameterizedTest(name = "\"{0}\"값이 String 의 substring() 메소드를 활용해 () 제거하고 \"{1}\"로 잘 분리되는지 확인")
    @CsvSource(value = {"(1,2):1,2"}, delimiter = ':')
    void substring(String input, String expected) {
        assertThat(input)
                .startsWith("(")
                .contains(expected)
                .endsWith(")");
        assertThat(input.substring(input.indexOf("(") + 1, input.lastIndexOf(")")))
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("요구사항 3 \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현")
    void charAt() {
        String input = "abc";
        assertAll(
                () ->assertThat(input.charAt(0)).isEqualTo('a'),
                () ->assertThat(input.charAt(1)).isEqualTo('b'),
                () ->assertThat(input.charAt(2)).isEqualTo('c'),
                () ->assertThatThrownBy(() -> {
                    input.charAt(input.length());
                }).isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range:")
                );
    }

}
