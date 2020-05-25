import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split1_1() {
        String testData = "1,2";
        String[] result = testData.split(",");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    void split1_2() {
        String testData = "1";
        String[] result = testData.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void split2() {
        String testData = "(1,2)";
        String result = testData.substring(1,4);

        assertThat(result).contains("1,2");
    }

    @DisplayName("StringIndexOutOfBoundsException Test")
    @Test
    void split3() {
        String testData = "abc";
        assertThatThrownBy(() -> {
            testData.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("out of range");
    }
}