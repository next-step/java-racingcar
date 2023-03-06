package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // Test Case 구현
    @DisplayName("Set의 크기를 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);

    }

    @DisplayName("Set의 크기를 확인")
    @Test
    void hasSize() {
        assertThat(numbers).hasSize(3);

    }


    @DisplayName("ParameterizedTest number Set에서 contains 값 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContains_set_value(final int number) {
        assertTrue(numbers.contains(number));
    }
}
