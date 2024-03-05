package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split_with_comma(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_with_no_comma(){
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void substring(){
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt이 문자열 크기 안에 있을떄 해당 위치 문자를 가져온다")
    void charAt_in_range(){
        char first = "abc".charAt(0);
        char second = "abc".charAt(1);
        char third = "abc".charAt(2);

        assertThat(first).isEqualTo('a');
        assertThat(second).isEqualTo('b');
        assertThat(third).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt이 문자열 크기를 초과했을떄 예외가 발생한다")
    void charAt_out_of_range(){
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("index out of range");
    }
}
