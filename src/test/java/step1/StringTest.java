package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] splitStr = "1,2".split(",");
        String[] splitOnly = "1".split(",");

        Assertions.assertThat(splitStr).contains("1", "2");
        Assertions.assertThat(splitStr).containsExactly("1", "2");

        Assertions.assertThat(splitOnly.length).isEqualTo(1);
        Assertions.assertThat(splitOnly).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);

        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void charAt() {
        String str = "abc";

        Assertions.assertThat(str.charAt(1)).isEqualTo('b');
        Assertions.assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져올 때 index 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_IndexOutOfBoundsException() {
        String str = "abc";

        Assertions.assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
