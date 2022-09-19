package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항 1 : split")
    void split_string() {
        // given
        String string = "1,2";

        // when
        String[] splitString = string.split(",");

        // then
        assertThat(splitString).contains("1");
        assertThat(splitString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 2 : substring")
    void substring_string() {
        // given
        String string = "(1,2)";

        // when
        String substringString = string.substring(1, string.length() - 1);

        // then
        assertThat(substringString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : 문자열 길이를 벗어나 chatAt() 메소드로 검색하면 StringIndexOutOfBoundsException 이 발생한다.")
    void exception_test() {
        // given
        String string = "abc";

        // expected
        assertThatThrownBy(() -> string.charAt(string.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
