package study;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1 : splitTest")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항2 : subStringTest")
    void subString() {
        String source = "(1,2)";

        assertThat(source.substring(1,source.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 : charAtTest")
    void charAtTest() {
        String name = "abc";
        int index = 10;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    name.charAt(index);
                });
    }
}
