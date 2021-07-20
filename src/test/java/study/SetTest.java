package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
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
    @DisplayName("Set의 크기를 확인한다.")
    void size() {
        int size = numbers.size();
        assertEquals(size, 3);
    }

    @DisplayName("특정값을 포함하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("1,2,3은 true, 4,5는 false를 반환한다.")
   @ParameterizedTest
    @CsvSource(value = {"1$true", "2$true", "3$true", "4$false", "5$false"}, delimiter = '$')
    void when123ThenTrueAndWhen45ThenFalse(int input, boolean expected) {
        Boolean actualValue = numbers.contains(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @DisplayName("비어있는 문자열인지 확인한다.")
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(Strings.isNullOrEmpty(input.trim()));
    }

    @ParameterizedTest
    @CsvSource(value = {"test$test", "tEst$test", "Java$java"}, delimiter = '$')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }
}
