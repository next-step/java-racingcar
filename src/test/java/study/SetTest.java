package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메서드가 Set의 크기를 잘 반환하는지")
    @Test
    void sizeLearningTest() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("numbers에 1, 2, 3 값이 모두 존재하는지")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsLearningTest(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }
}
