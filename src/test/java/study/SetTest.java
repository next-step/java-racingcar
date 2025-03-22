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

    @Test
    @DisplayName("1,1,2,3을 넣으면 size는 3이다.")
    void getSize() {
        assertThat(this.numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    @DisplayName("1,1,2,3을 넣으면 1,2,3을 포함한다.")
    void contains(int number) {
        assertThat(this.numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false" }, delimiter = ',')
    void exactlyContains(int input, boolean expected) {
        assertThat(this.numbers.contains(input)).isEqualTo(expected);
    }
}