package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String data = "(1,2)".substring(1,4);

        assertThat(data).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드를 통해 특정 위치의 값을 반환한다.")
    @Test
    void charAt_validIndex() {
        String data = "abc";

        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');

    }

    @DisplayName("charAt() 메소드에서 위치를 벗어나면  StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAt_invalidIndex() {
        String data = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(-1);
        }).withMessageMatching("String index out of range: -?\\d+");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(3);
        }).withMessageMatching("String index out of range: -?\\d+");

    }
}
