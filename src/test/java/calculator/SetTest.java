package calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("size() 메소드를 활용해 Set 크기를 확인한다.")
    void checkSetSize() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContainsOneTwoThree(int input) {
        assertTrue(input >= 1 && input <= 3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1: true", "2: true", "3: true", "4: false", "5: false"}, delimiter = ':')
    void setContainsOneTwoThreeFourFive(int input, boolean expected) {
        if (input <= 3) {
            assertTrue(expected);
        } else {
            assertFalse(expected);
        }
    }
}
