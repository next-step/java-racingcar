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

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @Test
    @DisplayName("size()를 통해 Set의 크기를 확인할 수 있다.")
    void size() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest(name = "{displayName} {index}이 존재 하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains()를 통해 Set에 값이 존재하는지 확인할 수 있다.")
    void contains_01(int value) {
        assertTrue(numbers.contains(value));
    }

    @ParameterizedTest(name = "{displayName} {index}이 존재 하는지 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains()를 통해 Set 값의 존재/비존재 여부를 확인할 수 있다.")
    void contains_02(int value, boolean expected) {
        assertEquals(expected, numbers.contains(value));
    }
}
