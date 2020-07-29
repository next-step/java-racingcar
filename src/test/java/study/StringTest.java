package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String given = "1,2";

        String[] result = given.split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void subString() {
        String given = "(1,2)";

        String removeOnce = given.substring(given.indexOf("(")+1);

        String result = removeOnce.substring(0,removeOnce.indexOf(")"));

        assertThat(result).contains("1,2");
    }

    @Test
    void charAt() {
        String given = "abc";
        assertThatThrownBy(()->given.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
