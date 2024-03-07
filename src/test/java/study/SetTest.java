package study;

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
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test 구현
    @Test
    void size(){
        int result = numbers.size();
        assertThat(result).isEqualTo(numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void containsOnlyTrueCase(int number)
    {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void containsExpectedNumber(int number, boolean expectedResult)
    {
        assertThat(numbers.contains(number)).isEqualTo(expectedResult);
    }

}
