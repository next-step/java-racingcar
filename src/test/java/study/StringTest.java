package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("문자열을 \",\"로 split했을 때 잘 분리되는지 확인한다.")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("포함하지 않는 문자열로 split했을 때를 확인한다.")
    void split2() {
        String[] result = "1".split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("subString을 활용하여 괄호를 제거한다.")
    void substring() {
        String str = "(1,2)";
        String substring = str.substring(1, str.length() - 1);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt()으로 특정 위치의 문자를 가져온다.")
    void charAt() {
        String str = "abc";
        char a = str.charAt(0);
        char b = str.charAt(1);
        char c = str.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()으로 범위를 벗어난 위치에 접근하면 예외가 발생한다.")
    void charAt2() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(3))
                .withMessageMatching("Index \\d+ out of bounds for length \\d+");
    }
}
