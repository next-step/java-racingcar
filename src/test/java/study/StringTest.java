package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - split 이용하기")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }


    @Test
    @DisplayName("요구사항2 - (1,2) substring 이용하기")
    void substringTest() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - abc의 문자열을 charAt 메소드를 이용해서 특정 문자 가져오기")
    void chatAtTest() {
        String text = "abc";
        assertThat(text).isEqualTo('a');
        assertThat(text).isEqualTo('b');
        assertThat(text).isEqualTo('c');

        assertThatThrownBy(() -> {
            text.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
