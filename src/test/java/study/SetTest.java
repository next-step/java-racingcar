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

    @DisplayName("size() 메서드를 사용해 Set의 크기를 구한다.")
    @Test
    void getSizeOfSetBySize() {
        // then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("@ParameterizedTest, @ValueSource를 사용해 Set의 요소를 검사한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkSetElementsWithParameters(int input) {
        // then
        assertThat(numbers).contains(input);
    }

    @DisplayName("@ParameterizedTest, @CsvSource를 사용해 Set의 요소를 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkSetElementsWithCsvParameters(int input, boolean expected) {
        // then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
