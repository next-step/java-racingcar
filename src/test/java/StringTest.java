import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @Test

    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 벗어난 위치를 지정하면 StringIndexOutOfBoundsException이 발생한다.")
    void charAtStringIndexOutOfBoundsException() {
        String str = "abc";
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThatThrownBy(() -> str.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
