package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 테스트")
    @Test
    void charAt() {
        char result = "abc".charAt(2);
        assertThat(result).isEqualTo('c');

        assertThatThrownBy(() -> {
            char result2 = "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
