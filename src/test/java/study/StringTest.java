package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1")
    void splitTest1() {
        //given
        String data = "1,2";

        //when
        String[] result = data.split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2")
    void substringTest2() {
        //given
        String data = "(1,2)";

        //when
        String result = data.substring(1, 4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3: StringIndexOutOfBoundsException test")
    void charAtTest() {
        //given
        String data = "abc";

        //when
        Throwable thrown = catchThrowable(() -> {
            char a = data.charAt(3);
        });

        //then
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }
}
