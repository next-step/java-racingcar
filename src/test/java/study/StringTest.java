package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 성공적으로 반환한다.")
    void IndexTest() {
        String value = "abc";
        char result = value.charAt(1);

        assertThat(result).isEqualTo('b');
    }
}
