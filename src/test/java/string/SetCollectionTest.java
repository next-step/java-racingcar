package string;

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

    @DisplayName("set collection size 확인")
    @Test
    void size() {
        //when, then
        assertEquals(numbers.size(), 3);
    }

    @DisplayName("값 존재여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int value) {
        //when, then
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("값 존재여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false"})
    void containsOrNot(int value, boolean expected) {
        //when, then
        assertEquals(expected, numbers.contains(value));
    }
}
