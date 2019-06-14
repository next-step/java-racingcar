package stringClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    public void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result[0]).contains("1");
        assertThat(result[1]).isEqualTo("2");
    }

    @Test
    public void splitContainTest() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    public void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    public void charAtTest() {
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    public void charAtExceptionTest() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(10);
                });
    }



}
