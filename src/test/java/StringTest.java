import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void multipleElementSplitTest() {
        String input = "1,2";
        String[] output = input.split(",");
        assertThat(output).containsExactly("1", "2");
    }

    @Test
    public void singleElementSplitTest() {
        String input = "1";
        String[] output = input.split(",");
        assertThat(output).containsExactly("1");
    }

    @Test
    public void substringTest() {
        String input = "(1,2)";
        String output = input.substring(1, input.length() - 1);
        assertThat(output).isEqualTo("1,2");
    }

    @DisplayName("charAt의 일반적인 동작 테스트")
    @Test
    public void charAtTest() {
        String input = "abc";
        char output = input.charAt(1);
        assertThat(output).isEqualTo('b');
    }

    @DisplayName("charAt에서 범위를 넘어선 값을 입력 받았을 때 동작 테스트")
    @Test
    public void outOfBoundCharAtTest() {
        String input = "abc";
        assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 4");

    }
}
