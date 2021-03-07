import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void containsTest() {
        String data = "1,2";
        String[] split = data.split(",");

        assertThat(split).contains("1","2");
    }

    @Test
    public void containsExactlyTest() {
        String data = "1";
        String[] split = data.split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    public void substringTest() {
        String data = "(1,2)";
        String substring = data.substring(1, 3);

        assertThat(substring).doesNotStartWith("(").doesNotEndWith(")");
    }

    @DisplayName("StringIndexOutOfBoundsException test")
    @Test
    public void charAtTest() {
        String data = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(4));
    }
}
