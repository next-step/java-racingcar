package study;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    // Test Case 구현
    // 요구사항 1
    @Test
    void sizeTest() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    // 요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {
        Assertions.assertThat(numbers.contains(number)).isTrue();
    }

    //요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueOrFalseTest(String input, String expected) {
        Assertions.assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(expected));
    }
}
