package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    public void checkSetSize() {
        int actual = numbers.size();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest를 활용해 Set이 특정 값을 포함하는지 확인한다.")
    void containsValue(final int input) {
        boolean actual = numbers.contains(input);
        boolean expected = true;

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource를 활용해 Set이 특정 값을 포함하는지 확인한다.")
    void containsValueWithExpectedResult(final int input, final boolean expected) {
        boolean actual = numbers.contains(input);

        assertEquals(expected, actual);
    }
}
