package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    void splitOnSingleValue() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    void substring() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스의 charAt 메소드에 대해 테스트한다.")
    void charAt() {
        String value = "abc";

        assertThat(value.charAt(0)).isEqualTo('c');

        assertThatThrownBy(() -> {
            value.charAt(value.length() + 1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
