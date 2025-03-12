package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("size() Test")
    void size() {
        // 1. Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() ParameterizedTest")
    void contains_ShouldReturnTrueForContainsNumbers(int number) {
        // 2. Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현
        // JUnit의 ParameterizedTest를 활용해 중복 코드를 제거
        assertThat(numbers.contains(number)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("contains() ParameterizedTest with CsvSource")
    void contains_ShouldReturnExpectedForInput(int input, boolean expected) {
        // 3. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현
        assertEquals(expected, numbers.contains(input));
    }

}
