package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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
    @Test
    @DisplayName("test Set size()")
    void setSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("test Set contains() with ValueSource")
    void setContainsWithValueSource(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest(name = "test Set contains() with CsvSource")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContainsWithCsvSource(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

    //******** code review

    @ParameterizedTest
    @MethodSource("invalidParameterReview")
    void setContains(int number, boolean expected){
        assertEquals(expected, numbers.contains(number));
    }

    static Stream<Arguments> invalidParameterReview() {
        return Stream.of(
                arguments(1, true),
                arguments(2, true),
                arguments(3, true),
                arguments(4, false),
                arguments(5, false)
        );
    }
}
