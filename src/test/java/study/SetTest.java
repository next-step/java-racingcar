package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("numbers에 1, 2, 3 값이 모두 존재하고 4, 5는 존재하지 않는지")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsLearningTest(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}
