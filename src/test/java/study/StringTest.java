package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void splitTest(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subStringTest(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("특정위치 문자 가져오는 테스트")
    void charAtGetTest(){
        String text = "abc";
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            text.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
          .hasMessageContaining("String index out of range");
    }
}
