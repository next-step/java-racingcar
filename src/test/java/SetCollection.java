import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetCollection {

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
    @DisplayName("Set collection 의 크기는 3이다.")
    void size_of_set_method() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set 에 1,2,3 의 값이 존재한다.")
    void is_contains_1_and_2_and_3(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("input 값이 Set 에 존재하는지 확인한다.")
    void boolean_test_for_all_input_number(String inputNum, String expectedResult) {
        final int parsedNumber = Integer.parseInt(inputNum);

        final boolean actual = numbers.contains(parsedNumber);

        assertEquals(String.valueOf(actual), expectedResult);
    }
}
