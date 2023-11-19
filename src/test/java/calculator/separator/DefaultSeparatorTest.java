package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class DefaultSeparatorTest {

    private Separator separator;

    @BeforeEach
    void setUp() {
        separator = new DefaultSeparator();
    }

    @ParameterizedTest
    @DisplayName("기본 구분자를 사용했는지 확인한다.")
    @CsvSource(value = {"1:3, true", "4,5, true", "1&4, false"})
    void matchable(String given, boolean expected) {
        // when
        boolean result = separator.matchable(given);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("기본 구분자를 가지는 문자열을 전달한 경우 구분자를 기준으로 분리한다.")
    @MethodSource("parametersProvider")
    void separate(String given, List<String> expected) {
        // when
        List<String> result = separator.separate(given);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("1,3", Arrays.asList("1", "3")),
                arguments("1:3", Arrays.asList("1", "3"))
        );
    }
}