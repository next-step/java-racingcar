package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2 분리 테스트")
    void mission1_1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("1 분리 테스트")
    void mission1_2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring 테스트")
    void mission2() {
        String str = "(1,2)";
        String result = str.substring(1, str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void mission3_1() {
        String str = "abc";
        char c = str.charAt(0);
        assertThat(c).isEqualTo('a');

    }

    @Test
    @DisplayName("Exception 테스트 1")
    void mission3_2() {
        String str = "abc";
        int index = 10;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(index);
                }).withMessageContaining("%d", index);

    }

    @Test
    @DisplayName("Exception 테스트 2")
    void mission3_3() {
        String str = "abc";
        int index = 10;
        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: "+index);

    }
}
