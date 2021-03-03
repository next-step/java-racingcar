package study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 활용해 Set 의 크기를 확인")
    void size() {
        int numbersSize = numbers.size();

        assertEquals(3, numbersSize );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인 (@ParameterizedTest 사용)")
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("contains() 메소드를 활용해 존재하는 값 과 존재하지 않는 값 확인 (@ParameterizedTest 사용)")
    void contains2(int number, boolean expectedBoolean) {
        assertEquals(expectedBoolean, numbers.contains(number));
    }

}
