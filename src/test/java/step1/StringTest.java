package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void contains() {
        assertThat("1,2".split(","))
                .contains("1", "2");
        assertThat("1,".split(",")).containsExactly("1");
    }

    @Test
    public void requirements2() {
        String input = "(1,2)";
        String output = input.substring(input.indexOf("(") + 1, input.lastIndexOf(")"));
        assertThat(output).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 테스트, 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 Exception 발생")
    public void requirements3() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");

    }
}
