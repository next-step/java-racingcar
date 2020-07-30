package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    public void substring() {
        String str = "(1,2)".substring(1,4);
    }

    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
=======

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

>>>>>>> e20b19bf346217ecd7ec060849d7136534781bc9
    }
}
