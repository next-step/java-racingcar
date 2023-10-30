package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
    }
    @Test
    void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }
    @Test
    void split3() {
        String str = "(1,2)";
        String result = str.substring(1, str.length()-1);
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("charAt 함수를 이용하여 올바른 char 가져오는지 확인 테스트")
    void charAtTest() {
        Character result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }
    @Test
    @DisplayName("charAt 함수를 이용할 때, 문자 길이보다 긴 Index 입력 시, IndexOutOfBoundsException 에러가 발생하는지 테스트")
    void charAtErrorTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
