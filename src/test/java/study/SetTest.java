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
    @DisplayName("Set의 size()를 활용해 Set의 크기를 확인하는 Test")
    void size() {
        int setSize = numbers.size();
        assertThat(numbers).hasSize(setSize);
    }

    @DisplayName("Set의 contains()를 이용해 값이 존재하는지 확인하는 Test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("JUnit CsvSource를 이용한 Contain(true) Test")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true"}, delimiter = ':')
    void csvSource1(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    @DisplayName("JUnit CsvSource를 이용한 Contain(false) Test")
    @ParameterizedTest
    @CsvSource(value = {"4:false", "5:false"}, delimiter = ':')
    void csvSource2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
