import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Set의 크기를 확인할 수 있어야 한다.")
    void testGetSizeOfSet() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("Set 안에 특정 값이 존재하는지 확인할 수 있어야 한다.")
    @ValueSource(ints = {1, 2, 3})
    void testFindValueInSet(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @DisplayName("Set 안에 특정 값이 존재하는지 안 하는지 확인할 수 있어야 한다.")
    @CsvSource(value = {"1:TRUE", "3:TRUE", "5:FALSE"}, delimiter = ':')
    void testFindValueInSet(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }
}
