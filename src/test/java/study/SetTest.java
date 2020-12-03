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

    @DisplayName("numbers 크기가 일치하는지 확인한다.")
    @Test
    void checkSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("해당 값들이 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containValue1(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("해당 값이 존재하면 true, 존재하지 않으면 false 나오는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containValue2(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
