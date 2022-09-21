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

    @DisplayName("size() 메서드로 set 크기 확인")
    @Test
    void getSize() {
        //given & when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("1, 2, 3의 값이 존재하는지")
    @ParameterizedTest(name = "{index}: {displayName} name={0}")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("contains 실행 결과에 따라 true/false 반환")
    @ParameterizedTest(name = "{index}: {displayName} name={0}")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsTrueOrFalse(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}