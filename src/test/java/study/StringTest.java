package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - split contains 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2 - split substring 확인")
    void split_substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 - charAt() 메소드 활용")
    void charAt() {
        String result = "abc";
        char findResult = result.charAt(0);
        assertThat(findResult).isEqualTo('a');
    }

    @Test
    @DisplayName("요구사항3 - charAt() 사용 시 StringIndexOutOfBoundsException 예외 발생")
    void charAt_indexOutOfBoundException() {
        String result = "abc";
        assertThrows(StringIndexOutOfBoundsException.class, () -> result.charAt(100));
    }
}
