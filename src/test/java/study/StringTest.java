package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
    }

    @Test
    void splitWithoutComma() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("charAt으로 지정된 위치에 있는 char값을 가져오는지 확인")
    void charAt() {
        String target = "abc";
        assertThat(target.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt으로 stirng 범위 밖 값을 가져오려고 하면 exception을 던져주는지 확인")
    void charAtOutOfBounds() {
        String target = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            target.charAt(target.length());
        }).withMessageMatching("String index out of range: \\d+");
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            target.charAt(-1);
        }).withMessageMatching("String index out of range: -\\d+");
    }
}
