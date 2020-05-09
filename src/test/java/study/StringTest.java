package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("문자열 자르기 테스트1")
    void test1() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열 자르기 테스트2")
    void test2() {
        String target = "(1,2)";
        String result = target.substring(target.indexOf("(") + 1, target.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 길이 벗어난 charAt 테스트")
    void test3() {
        String text = "abc";
        int outOfIndex = 5;
        assertThatThrownBy(() -> {
            char result = text.charAt(outOfIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("Index: %s, Size: %s", outOfIndex, text.length());

    }
}
