package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("요구사항1")
    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");

    }

    @DisplayName("요구사항2")
    @Test
    void substring() {
        String var = "(1,2)";
        String result = "";
        int resultInt = var.length();

        result = var.substring(1,resultInt-1);

        assertThat(result).isEqualTo("1,2");

    }

    @DisplayName("요구사항3")
    @Test
    void charAt() {
        String var = "abc";

        assertThat(var.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> {
                                    assertThat(var.charAt(4)).isEqualTo('a');
                                 }).isInstanceOf(StringIndexOutOfBoundsException.class)
                                   .hasMessageContaining("Exception !!!!");

    }

}
