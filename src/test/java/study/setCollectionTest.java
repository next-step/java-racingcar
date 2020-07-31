package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class setCollectionTest {
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
    @DisplayName("Set의 길이가 3인지 확인")
    void SetSize() {
        assertThat(numbers).hasSize(3);
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("1, 2, 3의 값이 존재 하는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void SetContains(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("입력값이 Set에 있는지 확인")
    void SetContains2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
