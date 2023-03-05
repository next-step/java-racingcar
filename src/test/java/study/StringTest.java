package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        System.out.println(Arrays.toString(actual));
    }

    @Test
    void split2() {
        final String[] actual = "1,2".split(",");

        System.out.println(Arrays.toString(actual));
    }

    @Test
    void name() {
        final String actual = "(1,2)".substring(1, 3);
        assertThat(actual).isEqualTo("1, 2");
    }

    @Test
    void charAt2() {
//        final char actual = "abc".charAt(4);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }

    @DisplayName("특정 위치의 문자를 가져올 떄 위치 값을 벗어나면 String 블라블라 발생")
    @Test
    void charAt3() {
        final char actual = "abc".charAt(4);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4));
    }


    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void testSetUp() {
        assertThat(numbers.size()).isEqualTo(4);
        //assertThat(numbers).hasSize(4);
    }

    @ValueSource(ints = {1, 2, 3, 4})
    @ParameterizedTest
    void contains(final int num) {
        assertThat(numbers.contains(num)).isTrue();
    }
}