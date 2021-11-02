package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        assertThat(getSplitResult("1,2")).contains("1");
        assertThat(getSplitResult("1,2")).containsExactly("1", "2");

        assertThat(getSplitResult("1")).contains("1");
    }

    private String[] getSplitResult(String data) {
        return data.split(",");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자가 문자열 길이를 벗어나면 예외")
    @Test
    void charAt() {
        String data = "abc";

        assertThat(data.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> {
            data.charAt(10);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("index out of range: 10");
    }

}
