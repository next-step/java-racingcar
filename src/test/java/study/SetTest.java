package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("[요구사항1]Set의 size()가 잘 동작하는지 테스트")
    void When_Size_Then_ValidSetSize() {
        //when
        int ret = numbers.size();

        //then
        assertThat(ret).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("[요구사항2]Set에 포함된 숫자로 contains()를 호출했을 때 true 리턴 테스트")
    void Given_AddedNumber_When_Contains_Then_True(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("[요구사항3]Set에 포함/불포함 된 숫자로 contains() 호출했을 때 기대값이 나오는지 테스트")
    void Given_Numbers_When_Contains_Then_ExpectedValue(int number, boolean expected) {
        boolean actual = numbers.contains(number);
        assertThat(actual).isEqualTo(expected);
    }
}
