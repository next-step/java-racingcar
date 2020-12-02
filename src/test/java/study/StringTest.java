package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
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
        assertThat(input.substring(1, input.length() - 1))
                .isEqualTo(expected);
    }

    @Nested
    @DisplayName("요구사항 3")
    class charAtTest {
        private String value;

        @BeforeEach
        void setUp() {
            this.value = "abc";
        }

        @DisplayName("String의 chartAt() 메소드 학습 테스트를 구현")
        @ParameterizedTest(name = "{0} 위치의 문자 ''{1}''를 반환하는지 확인")
        @CsvSource(value = {"0, a", "1, b", "2, c"})
        void charAt(int index, char expected) {
            assertThat(value.charAt(index))
                    .isEqualTo(expected);
        }

        @Test
        @DisplayName("StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
        void shouldStringIndexOutOfBoundsExceptionByCharAt() {
            // given
            int outOfIndex = value.length();

            // when
            Throwable thrown = catchThrowable(() -> {
                value.charAt(outOfIndex);
            });

            // then
            assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageStartingWith("String index")
                    .hasMessageContaining("out of range:")
                    .hasMessageEndingWith(String.valueOf(outOfIndex));
        }
    }

}
