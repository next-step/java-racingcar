package study;

import org.junit.jupiter.api.BeforeEach;
<<<<<<< HEAD
=======
import org.junit.jupiter.api.Nested;
>>>>>>> 2f563663486c84b8f8713cec53bc3ef69d1d9355
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() {
<<<<<<< HEAD
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void containsFalse(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
=======
        assertThat(numbers).hasSize(3);
    }

    @Nested
    class ContainsTest {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void contains(int num) {
            assertThat(numbers).contains(num);
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
        void containsFalse(int num, boolean expected) {
            assertThat(numbers.contains(num)).isEqualTo(expected);
        }
>>>>>>> 2f563663486c84b8f8713cec53bc3ef69d1d9355
    }
}
