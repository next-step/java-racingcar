package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitTest1() {
        String num = "1,2";
        String[] split = num.split(",");
        assertThat(split).containsExactly("1", "2");
    }
    @Test
    void splitTest2() {
        String num = "1";
        String[] split = num.split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substringTest() {
        String num = "(1,2)";
        String substring = num.substring(1,num.length()-1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 인덱스 값을 초과하면 StringIndexOutOfBoundsException 에러가 발생한다.")
    void charAtTest() {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(str.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
