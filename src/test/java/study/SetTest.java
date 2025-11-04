package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("Set의 크기를 확인 할 수 있다")
    @Test
    void checkSize() {
        //given
        int expected = 3;

        //when
        int actual = numbers.size();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 값이 Set에 존재하는지 확인 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkAllValues(int value) {
        //when && then
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("주어진 값이 Set에 존재하면 참을, 없다면 거짓을 응답 할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void checkAllValues(int value, boolean expected) {
        //when && then
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }

}
