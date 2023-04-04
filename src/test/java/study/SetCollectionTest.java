package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 1
    @Test
    @DisplayName("Set size test")
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    // 2
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set contains test")
    void containsV1(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    // 3
    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("Set contains test with multiple test case")
    void containsV2(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }

}
