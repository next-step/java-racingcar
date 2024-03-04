package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertThat(result1).containsExactly("1","2");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void split2() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("charAt 메소드로 특정 위치의 문자를 가져온다.")
    void characterAtTest() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 메소드로 호출한 위치가 문자열 길이를 넘어가면 Exception이 발생한다.")
    void characterAtIndexTest() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(3);
                })
                .withMessageMatching("String index out of range: \\d+");

    }
}
