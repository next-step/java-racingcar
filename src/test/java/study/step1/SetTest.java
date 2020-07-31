package study.step1;

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
        assertThat(numbers).hasSize(3);
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.isEmpty()).isFalse();
        assertThat(!numbers.isEmpty()).isTrue();
    }

    @DisplayName("요구사항2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest1(int number) {
        assertThat(numbers.contains(number)).isTrue();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항3")
    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    void containsTest2(int number, boolean isValid) {
            assertThat(numbers.contains(number)).isEqualTo(isValid);
    }
}
