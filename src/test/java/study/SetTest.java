package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    void size() {
        int expectSize = 3;
        assertThat(numbers.size()).isEqualTo(expectSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용해 Set 값이 존재하는지를 확인한다.")
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1", "true:2", "true:3", "false:4", "false:5"}, delimiter = ':')
    @DisplayName("Set의 contains() 메소드를 활용해 Set 값이 true인지 false인지 확인한다.")
    void contains(boolean key, int value) {
        assertThat(numbers.contains(value)).isEqualTo(key);
    }

}
