package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneElementTest() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    void subStringTest() {
        String target = "(1,2)";

        target = target.substring(target.indexOf("(") + 1);
        target = target.substring(0, target.lastIndexOf(")"));
        assertThat(target).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드의 파라미터가 대상의 길이를 벗어나는 경우")
    void indexOutOfBoundExceptionTest() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = "abc".charAt(4);
                })
                .withMessage("Index out of Bound Exception")
                .withNoCause();
    }
}
