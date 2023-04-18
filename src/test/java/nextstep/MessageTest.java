package nextstep;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MessageTest {

    static Stream<Arguments> messageInputAndResult() {
        return Stream.of(
                Arguments.arguments("1", List.of("1")),
                Arguments.arguments("1,2:3", List.of("1", "2", "3")),
                Arguments.arguments("//;\n1;2;3", List.of("1", "2", "3"))
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void text_nullAndEmpty(String input) {
        assertThatThrownBy(() -> new Message(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "input: {0}, result: {1}")
    @MethodSource("messageInputAndResult")
    public void getTokens(String input, List<String> result) {
        assertThat(new Message(input).getTokens()).isEqualTo(result);
    }
}
