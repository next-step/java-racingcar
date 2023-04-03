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
    void setUp_함수_테스트() {
        numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("[요구사항 1] size() 테스트")
    void size_함수_테스트() {
        //given

        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("[요구사항 2] contains() 테스트")
    void contains_함수_테스트(int number) {
        //given

        //when

        //then
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"},
            delimiter = ':')
    @DisplayName("[요구사항 3] 입력값에 따라 결과값이 다른 경우 contains() 테스트")
    void 입력값_결과값_상이_contains_함수_테스트(int number, boolean expected) {
        //given

        //when

        //then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
