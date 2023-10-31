package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
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

    // Test Case 구현
    @DisplayName("size 테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    @ParameterizedTest(name = "set contains {0} = {1} 테스트")
    void contains(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
