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
    @DisplayName("요구사항1: Set size() 테스트")
    void setSizeTest() {
        //when
        //then
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("요구사항2: Set contains Parameterized 테스트")
    void containsTest(int num) {
        //when
        //then
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("요구사항3: Set contains @CsvSource 테스트")
    void containsTestTwo(int input, boolean expected) {
        //when
        //then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
