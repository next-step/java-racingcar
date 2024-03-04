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
    @DisplayName("1. size() 메소드 테스트")
    void sizeTest() {
        int output = numbers.size();

        assertThat(output).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("2. contains() 메소드 테스트, ParameterizedTest")
    void containsTest(int testInput) {
        assertThat(numbers.contains(testInput)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("3. contains() 메소드 테스트, ParameterizedTest + CsvSource")
    void containsTest2(String testInput, String testExpected) {
        int input = Integer.parseInt(testInput);
        boolean expected = Boolean.parseBoolean(testExpected);
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
