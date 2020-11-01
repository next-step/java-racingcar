package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void test1_1() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void test1_2() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void test2_1() {
        String str = "(1,2)";
        String result = str.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("a를 가져오는 학습 테스트")
    void test3_1_get_a() {
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo("a");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsExceptions 발생 학습 테스트")
    void test3_2_throw_StringIndexOutOfBoundsExceptions() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: \\d+");
    }


}
