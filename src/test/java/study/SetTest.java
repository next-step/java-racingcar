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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    @DisplayName("numbers set에 대한 초기화 작업")
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현")
    @Test
    void sizeTest() {
        int expectedSize = 3;
        assertThat(numbers.size() == expectedSize);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 " +
            "확인하는 학습테스트를 구현")
    @Test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_True_Test(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @Test
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_True_False_Test(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }
}
