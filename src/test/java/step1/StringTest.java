package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Nested
    @DisplayName("문자열을 특정 문자 기준으로 자르면,")
    class split_string_by_dash {

        @Test
        @DisplayName("특정 문자가 존재하여 여러개의 문자로 나뉜다")
        void split_test() {
            String[] result = "1,2".split(",");
            assertThat(result).containsExactly("1", "2");
        }

        @Test
        @DisplayName("특정 문자가 존재하지 않아 여러개의 문자로 나뉘지 않는다.")
        void split_single() {
            String[] result = "1".split(",");
            assertThat(result).hasSize(1).containsExactly("1");
        }
    }

    @Test
    @DisplayName("문자열에 대해, 원하는 위치에 대한 문자열을 추출한다.")
    void do_subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Nested
    @DisplayName("특정 문자의 위치를 가져올 때,")
    class get_specific_character {

        @Test
        @DisplayName("특정 문자를 가져온다.")
        void do_chatAt() {
            String target = "abc";
            char charactor = target.charAt(1);
            assertThatCode(() -> target.charAt(1)).doesNotThrowAnyException();
            assertThat(charactor).isEqualTo('b');
        }

        @Test
        @DisplayName("위치가 범위를 벗어나 예외를 반환한다.")
        void throw_IndexOutOfBoundsException_chatAt() {
            String target = "abc";
            assertThatThrownBy(() -> target.charAt(4)).isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}
