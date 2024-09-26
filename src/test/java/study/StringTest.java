package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String[] strings = "1,2".split(",");

        assertThat(strings).contains("1", "2");

        // 순서까지 정확하게 일치 해야함
        assertThat(strings).containsExactly("1", "2");
    }


    @Test
    void substring() {
        String value = "(1,2)";

        int start = value.indexOf("(");
        int end = value.indexOf(")");

        assertThat(value.substring(start + 1, end)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 특정 위치 확인하기")
    void charAt() {
        String value = "abc";

        assertThatThrownBy(() ->
                value.charAt(value.length() + 1)
        ).isInstanceOf(StringIndexOutOfBoundsException.class);

    }


}
