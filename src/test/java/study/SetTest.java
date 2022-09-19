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

//import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("set의 크기를 반환한다")
    void size_ShouldChangeSize() {
        int expected = 3;
        int actual = numbers.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("set은 1, 2, 3을 포함한다.")
    void contains_ShouldContainOneTwoThree() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set은 1, 2, 3을 포함한다.")
    void contains_ShouldContainOneTwoThreeWithParameterized(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThat(input.isBlank()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("set은 1, 2, 3을 포함하고, 4, 5를 포함하지 않는다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int number, boolean expected) {
        boolean actual = numbers.contains(number);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actual = input.toLowerCase();
        assertThat(actual).isEqualTo(expected);

    }
}
