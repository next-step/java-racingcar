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
    @DisplayName("요구사항1 - size 테스트")
    void sizeTest() {
        //when
        int numbersSize = numbers.size();

        //then
        assertEquals(3, numbersSize);
    }

    @ParameterizedTest(name = "요구사항2 - numbers.contains({0}) is true")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {
        //then
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest(name = "요구사항3 - numbers.contains({0}) is {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTestWithFalse(int number, boolean expected) {
        //when
        boolean actualValue = numbers.contains(number);

        //then
        assertEquals(expected, actualValue);
    }
}
