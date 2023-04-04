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

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String.substring() 메소드를 이용하여 "1,2" 반환
     */
    @Test
    @DisplayName("String.subString() test")
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }


}
