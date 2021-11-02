package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void contains(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void containsUsingCsvSource(String input, String expected) {
        assertEquals(numbers.contains(Integer.parseInt(input)),Boolean.valueOf(expected));
    }
}