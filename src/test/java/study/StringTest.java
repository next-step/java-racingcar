package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String split() 메소드 테스트")
    void split() {
        String[] result = "1,2,".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String subString() 메소드 테스트")
    public void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }


    @Test
    @DisplayName("String charAt() 메소드 테스트")
    public void charAt() {
        String data = "abc";

        assertThat(data.charAt(1)).isEqualTo('b');

        assertThatThrownBy(() -> {
            char result = data.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = data.charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
