package study.learning;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// String 클래스에 대한 학습 테스트
@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("문자열 1,2 나누기")
    public void splitText01() throws Exception {
        // given
        String[] result = "1,2".split(",");

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 1, 나누기")
    public void splitText02() throws Exception {
        // given
        String[] result = "1,".split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 (1,2) substring 으로 ()제거하기")
    public void removeText() throws Exception {
        // given
        String data = "(1,2)";

        // when
        String result = data.substring(1, data.length()-1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 abc 뽑아내기")
    public void selectAlphabet() throws Exception {
        // given
        String data = "abc";

        // then
        assertEquals(data.charAt(0), 'a');
        assertEquals(data.charAt(1), 'b');
        assertEquals(data.charAt(2), 'c');

        assertThatThrownBy(() -> {
            data.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
