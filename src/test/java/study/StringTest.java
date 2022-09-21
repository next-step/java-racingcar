package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - split 활용")
    void splitTest() {
        String[] list = "1,2".split(",");

        assertThat(list).contains("1");
        assertThat(list).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사향2 - substring 활용")
    void substringTest() {
        String str = "(1,2)".substring(1,4);

        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void charAtTest() {
        assertThatThrownBy(() -> {
            String str = "abc";
            str.charAt(4);}
        ).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
