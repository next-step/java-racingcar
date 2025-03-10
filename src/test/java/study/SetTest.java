package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Nested
    @DisplayName("sizeTest")
    class SizeTest {

        @Test
        @DisplayName("size가 반환 되는가?")
        void sizeTest() {
            // then
            Assertions.assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("containsTest")
    class ContainsTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("값이 포함되어 있는가?")
        void containsTest(int testData) {
            // then
            Assertions.assertThat(numbers.contains(testData)).isTrue();
        }
    }
}
