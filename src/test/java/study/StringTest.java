package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1: split, 생성된 배열 확인")
    public void split() {
        assertThat("1,2".split(","))
                .containsExactly("1", "2");

        assertThat("1,".split(","))
                .containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2: substring, 새로운 문자열 생성")
    public void substring() {
        String str = "(1,2)";
        assertThat(str.substring(str.indexOf("(") + 1, str.indexOf(")")))
                .isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3: chatAt, 문자열 인덱스 범위를 벗어나면 IndexOutOfBoundsException 발생")
    public void chatAt() {
        String str = "abc";

        for (int i = 0; i < str.length() + 1; i++) {
            final int index = i;
            if (i < str.length())
                assertThat(str.charAt(i))
                                .isEqualTo(str.toCharArray()[i]);
            else
                assertThatThrownBy(() -> str.charAt(index))
                        .isInstanceOf(IndexOutOfBoundsException.class);
        }
    }
}
