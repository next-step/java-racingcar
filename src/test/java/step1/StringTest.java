package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("두 요소의 split이 잘 동작하는 지 확인한다.")
    void split_two_char() {
        String string = "1,2";
        String delimiter = ",";

        assertThat(string.split(delimiter)).contains("1");
        assertThat(string.split(delimiter)).contains("2");
        assertThat(string.split(delimiter)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("한 요소의 split이 잘 동작하는 지 확인한다.")
    void split_one_char() {
        String string = "1";
        String delimiter = ",";

        assertThat(string.split(delimiter)).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드가 잘 동작하는 지 확인한다.")
    void substring() {
        String string = "(1,2)";

        assertThat(string.substring(1, string.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 이용해 입력한 숫자의 인덱스에 위치한 문자를 가져와야 한다.")
    void charAt() {
        String string = "abc";

        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(string.length() - 1)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt을 이용해 위치의 범위를 벗어난 인덱스를 지정했을 경우 StringIndexOutOfBoundsException이 발생해야 한다.")
    void charAt_index_exception() {
        String string = "abc";

        assertThatThrownBy(() -> {
            string.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageMatching("String index out of range: \\d+");
    }
}
