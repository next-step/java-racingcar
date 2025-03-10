import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    // Test Case 구현

    // requirement 1
    @Test
    public void requirement1() {
        int expectedSize = 4;
        int actualSize = numbers.size();
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    // requirement 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void requirement2(int input) {
        System.out.println("Test input = " + input);
        assertThat(numbers.contains(input)).isTrue();
    }

    // requirement 3
    @ParameterizedTest
    @CsvSource(
            value = {"1:true", "2:true", "3:true", "4:false", "5:false"},
            delimiter = ':')
    public void requirement3(String input, String expected) {
        System.out.printf("Test input = %s, expected = %s%n", input, expected);
        boolean actual = numbers.contains(Integer.parseInt(input));
        assertThat(actual).isEqualTo(Boolean.parseBoolean(expected));
    }
}
