package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split test")
    void split() {
        String[] values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
        values = "1".split(",");
        assertThat(values).contains("1");
    }

    @Test
    @DisplayName("substring test")
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치 문자 가져오기1")
    void charAt() {
        String text = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    text.charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }

    @Test
    @DisplayName("특정위치 문자 가져오기2")
    void charAt2() {
        String text = "abc";
        assertThatThrownBy(() ->{
            text.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range: 3");
    }
}
