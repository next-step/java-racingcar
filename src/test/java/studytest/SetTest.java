package studytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        int expectedSetSize = 3;

        int actualSetSize = numbers.size();

        assertThat(actualSetSize).isEqualTo(expectedSetSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("(contains) test only with valid numbers -> return all true")
    void contains_only_with_valid_numbers(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("(contains) test with valid & invalid numbers -> return true or false")
    void contains_with_valid_and_invalid_numbers(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
