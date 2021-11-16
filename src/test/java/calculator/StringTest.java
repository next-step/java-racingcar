package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split() {

        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1","2");

        data = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @Test
    void subString() {
        String data = "(1,2)";

        int start = data.indexOf("(");
        int end = data.indexOf(")");
        String result = data.substring(start+1, end);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("IndexOut Exception Test")
    void charAt() {
        String inputData = "abc";

        assertThatThrownBy(() -> {
            inputData.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
