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

    // Test Case 구현
    @DisplayName("요구사항 1")
    @Test
    void setTest(){
        setUp();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    @DisplayName("요구사항 2 - ParameterizedTest 사용")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void seriesSetTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항 3")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void exceptionSetTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}