package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 분리되는지
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지
     */
    @Test
    @DisplayName("String.split() test")
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).contains("1", "2");
        assertThat(result1).containsExactly("1", "2");

        assertThat(result2).contains("1");
        assertThat(result2).containsExactly("1");
    }

}
