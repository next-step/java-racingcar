package stringadder;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAdderTest {
    @DisplayName("기본 구분자(, :) 및 커스텀 구분자를 기준으로 분리된 숫자의 합을 반환한다")
    @ParameterizedTest
    @MethodSource("numbers")
    void add(String numbers, int expected) {
        assertThat(new StringAdder(numbers).calculate()).isEqualTo(expected);
    }

    @DisplayName("구분자를 기준으로 분리된 숫자 중에서 음수가 있다면 RuntimeException 을 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = { "//,\n-1,2", "1,-2,3", "1,2:-3" })
    void add_when_negative_number(String numbers) {
        assertThatThrownBy(() -> new StringAdder(numbers).calculate()).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> numbers() {
        return Stream.of(
                Arguments.arguments("", 0),
                Arguments.arguments("1,2", 3),
                Arguments.arguments("1,2,3", 6),
                Arguments.arguments("1,2:3", 6),
                Arguments.arguments("//,\n1,2", 3),
                Arguments.arguments("//|\n1|2|3", 6),
                Arguments.arguments("//&\n1&2&3", 6)
        );
    }
}
