import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void string1() {
        String[] result1 = "1,2".split(",");
        String[] result2 = "1".split(",");

        assertThat(result1).contains("1");
        assertThat(result2).containsExactly("1");
    }

    @Test
    void string2()  {
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("잘못된 위치 값 예외발생")
    @Test
    void string3() {
        String stringParam = "abc";

        assertThatThrownBy(() -> stringParam.charAt(stringParam.length()))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}


