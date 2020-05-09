package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @DisplayName("Set의 크기를 확인한다")
    @Test
    void size() {
        int result = numbers.size();
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("Set에 값이 존재하는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set에 값이 존재하는지, 존재하지 않는지 확인한다")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "5,false"})
    void containsTrueFalse(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
