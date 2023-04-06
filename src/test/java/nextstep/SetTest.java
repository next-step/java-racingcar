package nextstep;

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
    @DisplayName("set() returns the number of elements in given set.")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "given value : {0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() verifies that the set contains the given values.")
    void containsWithExistingValues(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest(name = "given value : {0}, expected : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("If non-existent elements are used, contains() returns false.")
    void containsWithNonExistentValues(int value, boolean expected){
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
