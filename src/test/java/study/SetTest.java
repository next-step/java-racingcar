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
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메서드를 활용해 Set의 사이즈를 구한다.")
    public void sizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    public void containsTest(Integer input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false", "6,false"})
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    public void containsTestUsingCsvSource(Integer input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}