package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split() {
        String given = "1,2";

        String[] result = given.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String given = "(1,2)";

        String result = given.substring(1, given.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("음수 값이나 문자열의 길이를 초과할 경우 StringIndexOutOfBoundsException 반환한다")
    @Test
    void charAt() {
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
