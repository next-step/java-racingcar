package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

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
    void Set의_크기_확인_테스트() {
        assertThat(numbers.size()).isEqualTo(3);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Set에_특정_값이_존재하는지_테스트(final int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void Set에_입력한_값에_따라_결과값이_다른_경우_테스트(final int value, final boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
