package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }
    // Test Case 구현
    @ParameterizedTest
    @ValueSource(ints = {1,2,4}) // six numbers
//    @CsvSource(value = {"2", "3", "4"}, delimiter = ':')
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ',')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String result, String expected) {
        assertThat(numbers.contains(numbers)).isEqualTo(result);
    }
}
