package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size() 메서드를 통해 Collection의 크기를 검사한다")
    @Test
    void sizeOfSet() {
        final int size = numbers.size();

        assertEquals(3, size);
    }

    @DisplayName("contains 메서드는 element를 포함하고 있을 경우 true를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsElementsThenReturnTrue(int input) {
        final boolean result = numbers.contains(input);

        assertTrue(result);
    }

    @DisplayName("contains 메서드는 element를 포함하고 있는지 여부를 반환한다.")
    @ParameterizedTest(name = "{index} => 'numbers' set contains {0} is {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void containsElements(int input, boolean expectResult) {
        final boolean result = numbers.contains(input);

        assertEquals(expectResult, result);
    }
}
