package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringParserTest {

    @ParameterizedTest(name = "입력 값이 {arguments}일때")
    @MethodSource("blankString")
    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생한다")
    void constructor(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new StringParser(input));
    }

    static Stream<String> blankString() {
        return Stream.of(
                "", " ", null
        );
    }

    @Test
    @DisplayName("특정 문자열을 파싱했을때 아래와 같은 요소를 포함한다")
    void parse() {
        final String text = "2 + 3 * 4 / 2";
        final StringParser parser = new StringParser(text);

        final String[] actual = parser.parse();

        assertThat(actual).containsExactly("2", "+", "3", "*", "4", "/", "2");

    }
}