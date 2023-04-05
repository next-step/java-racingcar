package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {

    @Test
    void String의_split_메서드로_콤마의_문자열을_정상적으로_분리한다() {
        final var word = "1,2";

        final var actual = word.split(",");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void String의_split_메서드로_한개의_문자를_분리하면_동일한_문자를_반환한다() {
        final var word = "1";

        final var actual = word.split(",");

        assertThat(actual).containsExactly("1");
    }

    @Test
    void String의_substring_메서드로_소괄호를_제거한다() {
        final var word = "(1,2)";

        final var actual = word.substring(1, word.length() - 1);

        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메서드는 특정 위치의 문자를 가져온다.")
    void String의_charAt_메서드는_특정_위치의_문자를_반환한다() {
        final var word = "abc";

        final var actual = word.charAt(1);

        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("String의 charAt() 메서드에서 문자열의 위치값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다.")
    void String의_charAt_메서드에서_특정_위치값을_벗어나면_예외가_발생한다() {
        final var word = "abc";

        assertThatThrownBy(
                () -> word.charAt(10)
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
