package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void init() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() {
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_valueSource(int num) {
        assertTrue(numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource({"1,True", "2,True", "3,True", "4,False", "5,False"})
    void contains_csvSource(int num, boolean expected) {
        assertEquals(numbers.contains(num), expected);
    }
}
