package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SpringTest {

    @Test
    public void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    public void split2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void 요구사항2() {
        String result = "(1,2)".replace("(", "").replace(")", "");
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void 요구사항3() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "ABC".charAt(6));
    }
}
