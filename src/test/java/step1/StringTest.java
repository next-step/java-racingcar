package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split() 테스트")
    void split() {
        String[] arr1 = "1,2".split(",");
        assertThat(arr1).contains("1", "2");
        assertThat(arr1).containsExactly("1", "2");

        String[] arr2 = "1".split(",");
        assertThat(arr2).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 테스트")
    void subSting() {
        String str = "(1,2)".substring(1, 4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 기능 테스트")
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("chatAt() StringIndexOutOfBoundsException 예외 테스트")
    void charAtException() {
        String str = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(str.length()));
    }
}
