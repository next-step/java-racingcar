package step1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void split() {
        String[] result_1 = "1".split(",");
        assertThat(result_1).containsExactly("1");
        String[] result_2 = "1,2".split(",");
        assertThat(result_2).containsExactly("1", "2");
        assertThat(result_1).containsExactly("2", "1");
    }

    @Test
    public void substring() {
        String str = "(1,2)";
        String result = str.substring(1,str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
            String str = "0123456";
            Character result = str.charAt(11);
            assertThat(result).isEqualTo('1');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 11, Size: 7");

        assertThatThrownBy(() -> {
            String str = "0123456";
            Character result = str.charAt(1);
            assertThat(result).isEqualTo('1');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 1, Size: 7");
    }
}