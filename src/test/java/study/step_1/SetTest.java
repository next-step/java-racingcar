package study.step_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("size() 메소드를 활용해 numbers의 크기를 확인한다")
    void sizeShouldReturnSizeOfNumbers() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() 메소드를 활용해 numbers에 1, 2, 3이 존재하는지 ParameterizedTest로 확인한다")
    void containsShouldReturnTrueForAddedValues(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains() 메소드를 활용해 numbers에 1, 2, 3이 존재하면 true, 아니면 false를 반환한다")
    void containsShouldReturnTrueForAddedValuesAndReturnFalseForAnythingElse(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
