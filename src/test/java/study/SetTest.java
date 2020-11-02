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

    @DisplayName("크기 테스트")
    @Test
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("int 숫자열에 대한 순차적 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkHasInteger(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("csv 형태의 데이터에 대해 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkWithCsvSource(String input, String expected) {
        int actualValue = Integer.parseInt(input);
        boolean result = numbers.contains(actualValue);
        assertEquals(expected, Boolean.toString(result));
    }
}
