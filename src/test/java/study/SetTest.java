package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("numbers의 사이즈를 확인한다.")
    @Test
    void checkNumbersSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("인자로 들어온 값이 numbers에 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void checkContainNumbersValue(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("인자로 들어온 값이 numbers에 존재여부를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "5:false" }, delimiter = ':')
    void checkContainNumbersValue2(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
