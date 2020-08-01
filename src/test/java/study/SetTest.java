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
    @DisplayName("요구사항1")
    void sizeTest() {
        assertThat(this.numbers.size()).isEqualTo(3);
        assertThat(this.numbers).size().isGreaterThan(1);
    }

    @ParameterizedTest
    @DisplayName("요구사항2")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항3")
    @CsvSource(value = {"1:true", "2:true", "3:false"}, delimiter = ':')
    void containsBoolean(int number, boolean isExpected) {
        assertThat(numbers.contains(number)).isEqualTo(isExpected);
    }
}