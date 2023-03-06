package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("set size 확인")
    @Test
    void req1() {
        int num = numbers.size();
        assertThat(num).isEqualTo(3);
    }

    @DisplayName("1,2,3 값 존재여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void req2(int input) {
        assertThat(numbers.contains(input));
    }

    @DisplayName("요구사항 3: CsvSource 활용")
    @ParameterizedTest
    @CsvSource(value = {"4:false","5:false"}, delimiter = ':')
    void req3(int input, int expected) {
        int actual = input;
        assertEquals(expected, actual);
    }

}
