package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("1,2 분리")
    void splitTwo(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("1, 분리")
    void splitOne(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 분리")
    void splitBracket(){
        String[] result = "(1,2)".substring(1,4).split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("특정위치_문자_가져오기")
    void charAt(){
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("특정위치_벗어났을때_에러발생")
    void charAtThrowError(){
        String str="abc";
        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
