import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayName("String")
class StringTest {

    @Test
    @DisplayName("\"1,2\" 문자열을 \",\" 구분자로 하여 split 함수를 사용하면 1과 2로 분리된다.")
    void split01() {
        // when
        final var numbers = "1,2".split(",");

        // then
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\" 문자열을 \",\" 구분자로 하여 split 함수를 사용하면 1만 반환된다.")
    void split02() {
        // when
        final var numbers = "1".split(",");

        // then
        assertThat(numbers).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 문자열을 substring 함수를 활용해 \"()\"을 제거하면 \"1,2\"가 반환된다.")
    void substring01() {
        // given
        final var 괄호로_쌓인_숫자 = "(1,2)";

        // when
        final var 여는_괄호_위치 = 괄호로_쌓인_숫자.indexOf("(");
        final var 닫는_괄호_위치 = 괄호로_쌓인_숫자.indexOf(")");
        final var numbers = 괄호로_쌓인_숫자.substring(여는_괄호_위치 + 1, 닫는_괄호_위치);

        // then
        assertThat(numbers).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 문자열의 chatAt 함수 인자에 각각 위치 값을 주면 특정 위치의 문자를 반환한다")
    void chatAt01() {
        // given
        final var abc = "abc";

        // when
        final var 첫번째_위치의_문자 = abc.charAt(0);
        final var 두번째_위치의_문자 = abc.charAt(1);
        final var 세번째_위치의_문자 = abc.charAt(2);

        // then
        assertSoftly(softly -> {
            softly.assertThat(첫번째_위치의_문자).isEqualTo('a');
            softly.assertThat(두번째_위치의_문자).isEqualTo('b');
            softly.assertThat(세번째_위치의_문자).isEqualTo('c');
        });
    }

    @Test
    @DisplayName("\"abc\" 문자열의 chatAt 함수 인자에 위치값을 벗어나면 예외가 발생한다.")
    void chatAt02() {
        // given
        final var abc = "abc";
        final var 올바르지_않은_인덱스 = abc.length() + 5;

        // when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(올바르지_않은_인덱스))
                .withMessageMatching("String index out of range: \\d+");
    }
}
