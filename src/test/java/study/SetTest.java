package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("요구사항1 - set size 확인")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2")
    @ParameterizedTest(name = "{displayName} numbers contains {0}")
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }

    @DisplayName("요구사항3")
    @ParameterizedTest(name = "{displayName} numbers contains {0} is {1}")
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void parameterizedTest2(int argument, boolean expected) {
        assertThat(numbers.contains(argument)).isEqualTo(expected);
    }

}
