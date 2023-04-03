package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
    @DisplayName("크기가 4인 배열이 주어졌을 때, size() 메소드의 값이 3인지 확인한다.")
    void setTest1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "conatins 메소드가 값: {0}에 대해 정상동작하는지 확인한다.")
    @ValueSource(strings = {"1", "2", "3"})
    void contains(Integer value) {
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest(name = "conatins 메소드가 값: {0}에 대해 정상동작하는지 확인한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(Integer value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
