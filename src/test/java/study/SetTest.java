package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("size 테스트")
    @Test
    void testSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains 메서드 ValueSource를 이용한 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testParameterizedTest(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("contains 메서드 CsvSource를 이용한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void testCsvSource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
