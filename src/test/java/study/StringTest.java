package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


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

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을때 String.charAt() 메소드를 활용해 특정 위치 문자 가져오기
     */
    @Test
    @DisplayName("String.charAt() test")
    void charAt() {
        String result = "abc";
        char charResult = result.charAt(1);

        assertThat(charResult).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt()에서 assertThatThrownBy()을 사용하여 Exception처리")
    void assertThatThrownByTest() {
        String result = "abc";
        assertThatThrownBy(() -> {
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }

    @Test
    @DisplayName("charAt()에서 assertThatExceptionOfType()을 사용하여 Exception처리")
    void assertThatExceptionOfTypeTest() {
        String result = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {result.charAt(3);})
                .withMessageContaining("index out of")
                .withNoCause();
    }

}
