package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 테스트")
    void splitTest() {
        String num = "1,2";
        String[] splitExactlyStr = num.split(",");
        assertThat(splitExactlyStr).containsExactly("1","2");
    }

    @Test
    @DisplayName("substring 테스트")
    void substringTest() {
        String num = "(1,2)";
        String substringStr = num.substring(1, 4);
        assertThat(substringStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest() {
        String charStr = "abc";
        assertThat(charStr.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt Exception 테스트")
    void charAtExceptionTest() {
        String charStr = "abc";
        assertThatThrownBy(() -> {
            charStr.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
