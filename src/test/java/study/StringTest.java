package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        //given
        String testCase1 = "1,2";
        String testCase2 = "1";

        //when
        String[] result1 = testCase1.split(",");
        String[] result2 = testCase2.split(",");

        //then
        assertThat(result1).contains("1","2");
        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    void substring() {
        //given
        String testCase = "(1,2)";

        //when
        String result = testCase.substring(1,4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt()이 문자열 위치 값을 벗어나면 IndexOutOfBoundsException 발생")
    @Test
    void charAt() {
        //given
        String testCase = "abc";

        //then
        assertThatThrownBy(() -> {
            testCase.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range: 4");
    }
}
