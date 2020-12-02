package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("두 요소의 split을 하면 delimiter를 기준으로 분리된 배열이 생성된다.")
    void split_two_char() {
        String string = "1,2";
        String delimiter = ",";

        assertThat(string.split(delimiter)).contains("1");
        assertThat(string.split(delimiter)).contains("2");
        assertThat(string.split(delimiter)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("delimiter가 없는 문자의 경우에도 배열로 잘 분리되어야 한다.")
    void split_one_char() {
        String string = "1";
        String delimiter = ",";

        assertThat(string.split(delimiter)).containsExactly("1");
    }

    @Test
    @DisplayName("시작 index와 끝 index를 입력받아 substring 메소드가 잘 동작하는 지 확인한다. 시작 index~끝 index-1 만큼 분리된다.")
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
