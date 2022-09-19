package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {

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
    void sizeReturnsSizeOfSet() {
        Integer actual = numbers.size();
        Integer expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void containsReturnTrueWhenGivenElementIsInSet(Integer source) {
        Boolean actual = numbers.contains(source);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void containsReturnBooleanByWhetherGivenElementIsInSetOrNot(String sourceString, String expectedString) {
        Integer source = Integer.parseInt(sourceString);

        Boolean actual = numbers.contains(source);
        Boolean expected = Boolean.valueOf(expectedString);

        assertThat(actual).isEqualTo(expected);
    }
}
