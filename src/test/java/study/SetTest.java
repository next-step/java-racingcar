package study;

import org.junit.jupiter.api.Assertions;
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
    void size() {
        assertThat(numbers).size().isEqualTo(numbers.size());
    }

    @DisplayName("요구사항2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        Assertions.assertTrue(numbers.contains(num));
    }

    @DisplayName("요구사항3")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5"})
    void containsOtherCase(int one, int two, int three, int four, int five) {
        System.out.println(numbers.contains(one));
        System.out.println(numbers.contains(two));
        System.out.println(numbers.contains(three));
        System.out.println(numbers.contains(four));
        System.out.println(numbers.contains(five));
    }
}
