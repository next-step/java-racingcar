package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {

    private static Stream<Arguments> provideTokenResult() {
        return Stream.of(
                Arguments.of("3 + 5 / 2 * 5 + 10 - 5", new String[]{"3", "+", "5", "/", "2", "*", "5", "+", "10", "-", "5"})
        );
    }

    @DisplayName("식 을 토큰화 테스트")
    @ParameterizedTest
    @MethodSource("provideTokenResult")
    public void 식_토큰화_테스트(String input, String[] expected) {
        String delimiter = " ";
        String[] result = Tokenizer.tokenize(input, delimiter);

        assertThat(result).isEqualTo(expected);
    }
}
