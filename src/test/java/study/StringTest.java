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
    void substring() {
        String tmpString = "(1,2)";
        String result = tmpString.substring(1,4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()을 이용해 특정위치의 문자를 가져오기")
    void charAt() {
        String tmpString = "abc";

        assertThatThrownBy(() -> {
                assertThat(tmpString.charAt(10)).isEqualTo('a');
            }
        ).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
