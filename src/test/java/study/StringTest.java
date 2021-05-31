package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    public void 쉼표로_나누기1() throws Exception {
        final String text = "1,2";
        String[] split = text.split(",");

        assertEquals("1", split[0]);
        assertEquals("2", split[1]);

        Assertions.assertThat(split).contains("1", "2");
    }

    @Test
    public void 쉼표로_나누기2() throws Exception {
        final String text = "1";
        String[] split = text.split(",");

        assertEquals(1, split.length);
        assertEquals("1", split[0]);

        Assertions.assertThat(split).containsExactly("1");
    }

    @Test
    public void 예외발생시키기() {
        final int index = 3;
        final String input = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(index));
    }
}