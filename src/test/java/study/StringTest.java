package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

        String[] resultSecond = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void subStringTest() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }
    @DisplayName("문자열 abc에 함수 charAt 사용 -> StringIndexOutOfBoundsException 발생시키기 위해+" +
            "문자열 해당 index값 보다 높은 index값을 입력하고 Exception이 발생하는지 확인한다.")
    @Test
    void charAtTest() {
        String result = "abc";
        assertThatThrownBy(() -> {result.charAt(5);}).isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
