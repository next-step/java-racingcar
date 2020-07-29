package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpringTest {

    @Test
    public void split_test1() {
        String data = "1,2";
        String[] result1 = data.split(",");
        assertThat(result1).contains("1");
        assertThat(result1).contains("2");
        assertThat(result1).contains("3");
    }

    @Test
    public void split_test2() {
        String data2 = "1";
        String[] result2 = data2.split(",");
        assertThat(result2).containsExactly("1");
        assertThat(result2).doesNotContain("2");
    }

    @Test
    public void substring() {
        String data = "(1,2)";
        String result = data.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("test")
    @Test
    public void charAt() {
        String data = "abc";

        assertThatThrownBy(() -> {
            data.charAt(2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
