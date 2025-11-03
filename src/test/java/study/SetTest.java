package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("numbers Collection 사이즈 확인")
    @Test
    void checkSize() {
        int expectedSize = 3;

        assertEquals(expectedSize, numbers.size());
    }

    @DisplayName("입력 값이 numbers Collection에 모두 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkAllValues(int value) {
        assertTrue(numbers.contains(value));
        assertThat(numbers).contains(value);
    }

    @DisplayName("입력 값이 numbers Collection에 존재하면 true, 존재하지 않을 경우 false")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkAllValues(int value, boolean expected) {
        assertEquals(expected, numbers.contains(value));
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }

}
