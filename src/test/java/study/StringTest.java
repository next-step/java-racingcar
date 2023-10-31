package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String의 split 테스트")
    void split() {
        String[] testData1 = "1,2".split(",");

        assertThat(testData1).contains("1");
        assertThat(testData1).containsExactly("1","2");

        String[] testData2 = "1".split(",");

        assertThat(testData2).contains("1");
        assertThat(testData2).containsExactly("1");
    }

    @Test
    @DisplayName("String의 substring 테스트")
    void string1() {
        String testData1 = "(1,2)";
        String result = testData1.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt 테스트")
    void string2() {
        String testData1 = "abc";
        char result = testData1.charAt(0);

        assertThat(result).isEqualTo('a');

        assertThatThrownBy(() -> {
            testData1.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
