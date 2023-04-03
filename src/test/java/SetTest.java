import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @DisplayName("Set의 크기를 확인할 수 있어야 한다.")
    void testGetSizeOfSet() {
        Integer result = numbers.size();

        assertEquals(3, result);
    }

    @ParameterizedTest
    @DisplayName("Set 안에 특정 값이 존재하는지 확인할 수 있어야 한다.")
    @ValueSource(ints = {1, 2, 3})
    void testFindValueInSet(int input) {
        assertTrue(numbers.contains(input));
    }
}
