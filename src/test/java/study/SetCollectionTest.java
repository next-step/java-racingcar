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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetCollectionTest {
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
    @DisplayName("요구사항 1. check size of Set")
    void checkSizeOfSet() {
        int setSize = 3;
        assertThat(numbers).hasSize(setSize);
        assertEquals(3, numbers.size(), "Set의 크기는 3이어야 함");
    }

    @ParameterizedTest(name="요구사항 2. check contain - value={0}")
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest(name="요구사항 3. check contain - value={0}, expected={1}")
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void contains2(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
