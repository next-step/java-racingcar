package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String var = "(1,2)";
        String result = var.substring(1, var.length()-1);
        System.out.println(result);
    }

    @Test
    void charAt() {
        assertThatThrownBy( () -> {
            char result = "abc".charAt(1);
            System.out.println(result);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");;
    }
}
