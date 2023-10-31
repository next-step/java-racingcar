package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    @DisplayName("contains(true) - Set에 있는 값을 contains하면 True를 반환")
    void containsTrue(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints={4,10,12})
    @DisplayName("contains(false) - Set에 없는 값을 contains하면 False를 반환")
    void containsFalse(Integer input) {
        assertThat(numbers.contains(input)).isFalse();
    }
}
