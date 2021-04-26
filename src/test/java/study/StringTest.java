package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertEquals(split[0], "1");
        assertEquals(split[1], "2");
    }

    @Test
    void split2() {

        String split = "(1,2)".replaceAll("[(]", "").replaceAll("[)]", "");
        assertThat(split).contains("1,2");
    }

    @Test
    void charAt() {

        String charAt = "abc";
        char charAt1 = charAt.charAt(1);

        assertThatThrownBy(() -> {
            assertThat(charAt1).isEqualTo('b');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }
}