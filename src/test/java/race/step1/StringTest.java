package race.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {
    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
        assertThat(data).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환 확인")
    void subString() {
        String data = "(1,2)";
        String result = data.substring(1, data.length() -1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
    void stringCharAt() {
        String data = "abc";

        char a = data.charAt(0);
        char b = data.charAt(1);
        char c = data.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');

        // StringIndexOutOfBoundsException
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> data.charAt(data.length())).withMessageMatching("String index out of range: \\d+");
    }
}
