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


    @DisplayName("Set collection size test")
    @Test
    void collection_size_test() {
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @DisplayName("Set collection contains test")
    @Test
    void collection_contain_test() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("Set collection contains test with Junit ParameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void collection_contain_test_simple(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }


}
