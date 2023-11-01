package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp()
    {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Check size")
    @Test
    void size()
    {
        assertThat(numbers).size().isEqualTo(3);
    }

    @DisplayName("Study to use ParameterizedTest - Only True Case")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input)
    {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Study to use ParameterizedTest - With False Case")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains(int input, boolean expect)
    {
        boolean result = numbers.contains(input);
        assertThat(result).isEqualTo(expect);
    }
}
