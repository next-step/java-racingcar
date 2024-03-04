package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test @DisplayName("split메서드는 주어진 regex를 기준으로 문자열을 나눈 다음 그 배열을 반환한다(contains로 테스트해라)")
    void split_by_comma() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }
    @Test @DisplayName("split메서드는 주어진 regex를 기준으로 문자열을 나눈 다음 그 배열을 반환한다(containsExactly로 테스트해라)")
    void split() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test @DisplayName("substring메서드는 지정된 시작 인덱스부터 끝 인덱스 -1 까지의 문자열을 반환한다")
    void substring_test() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Test @DisplayName("chatAt메서드는 지정된 인덱스에 해당하는 문자를 반환한다")
    void char_at_test() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test @DisplayName("charAt메서드에서 값을 벗어나는 인덱스를 활용하려하면 StringIndexOutOfBoundsException이 발생한다(hasMessageContaining로 테스트해라)")
    void string_index_out_of_bounds_exception_test() {
        assertThatThrownBy(() -> {
            throw new StringIndexOutOfBoundsException("abc".charAt(4));
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 4");
    }

    @Test @DisplayName("charAt메서드에서 값을 벗어나는 인덱스를 활용하려하면 StringIndexOutOfBoundsException이 발생한다(withMessageMatching으로 테스트해라")
    void string_index_out_of_bounds_exception_with_message_match_test() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    throw new StringIndexOutOfBoundsException("abc".charAt(4));
              }).withMessageMatching("String index out of range: \\d+");
    }
}
