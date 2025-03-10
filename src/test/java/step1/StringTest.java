package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 분리된다.")
    void split1() {
        String text = "1,2";

        String[] actual = text.split(",");
        String[] expected = {"1", "2"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    void split2() {
        String str = "1";

        String[] actual = str.split(",");
        String[] expected = {"1"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환한다.")
    void substring() {
        String str = "(1,2)";

        String actual = str.substring(1, 4);
        String expected = "1,2";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void charAt1() {
        String str = "abc";

        char actual = str.charAt(0);
        char expected = 'a';

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt2() {
        String str = "abc";
        int outOfBoundsIndex = str.length() + 1;

        Throwable thrown = catchThrowable(() -> str.charAt(outOfBoundsIndex));

        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }
}
