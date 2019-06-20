package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private String[] result;

    @BeforeEach
    void setUp() {
        result = "1,2".split(",");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void subString() {
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void subString2() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf("(")+1, input.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    void charAt_outOfRange_fail() {
        assertThatThrownBy(() -> {
            String input = "abc";
            input.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void charAt_outOfRange_fail2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4)).withMessageMatching("String index out ofWinningCars range: \\d+");
    }

    @Test @DisplayName("junit contains")
    void split() {
        assertThat(result).hasSize(2);
        assertThat(result).contains("1").contains("2");
    }

    @Test @DisplayName("assertJ 순서 확인")
    void split2() {
        assertThat(result).containsExactly("1", "2");
    }
}
