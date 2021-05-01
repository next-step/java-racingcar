package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    // 요구사항 1
    @Test
    void test() {
        final String[] testvalue = "1,2".split(",");
        final String[] testvalue2 = "1".split(",");
        assertThat(testvalue).contains("1", "2");
        assertThat(testvalue[0]).isEqualTo("1");
        assertThat(testvalue2).containsExactly("1");
    }

    // 요구사항 2
    @Test
    void test2() {
        final String testvalue3 = "(1,(2)".replace("(", "").
                replace(")", "");
        assertThat(testvalue3).isEqualTo("1,2");
        assertThat(testvalue3).contains("1,2");
    }

    // 요구사항 3
    // 문자열 길이 초과해서 예외처리 확인하기
    @Test
    void test3() {
        final String testvalue4 = "abc";
        assertThatThrownBy(() -> {
                testvalue4.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}