package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void splitTest1() {
        String data = "1,2";
        String data2 = "1";
        String[] result = data.split(",");
        String[] result2 = data2.split(",");

        assertThat(result).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void splitTest2() {
        String data = "(1,2)";
        String result = data.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("주어진 string의 범위를 넘어가는 위치의 문자를 가져오면 Exception이 발생한다")
    void splitTest3() {
        String data = "abc";

        assertThrows(StringIndexOutOfBoundsException.class, () -> data.charAt(data.length() + 1));

    }
}
