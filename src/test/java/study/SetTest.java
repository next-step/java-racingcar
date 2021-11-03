package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항1 테스트 verify contains")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항2 테스트")
    void substringTest() {
        String value = "(1,2)";
        String result = value.substring(1, value.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 테스트")
    void charAtTest() {
        String value = "abc";
        int ascii = 97;
        AtomicInteger idx = new AtomicInteger(0);

        for (; idx.get() < value.length(); ) {
            assertThat(value.charAt(idx.getAndIncrement())).isEqualTo((char)ascii++);
        }

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> value.charAt(idx.get()))
                .withMessage("String index out of range: " + idx.get());
    }
}
