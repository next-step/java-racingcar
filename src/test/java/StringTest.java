import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    public void request1() {
        String str = "1,2";
        String[] arr = str.split(",");

        assertThat(arr).contains("1", "2");

        String str2 = "1";
        String[] arr2 = str2.split(",");

        assertThat(arr2).containsExactly("1");
    }

    @Test
    public void request2() {
        String str = "(1,2)";
        String subStr = str.substring(1, str.length() - 1);

        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt() 메서드 활용 테스트")
    public void request3() {
        String str = "abc";
        char a = str.charAt(0);
        char b = str.charAt(1);
        char c = str.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');

        assertThatThrownBy(() -> {
            char d = str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
