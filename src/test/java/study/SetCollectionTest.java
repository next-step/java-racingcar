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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCollectionTest {

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
    @DisplayName("Set의 크기를 측정")
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("값이 존재하는지 확인 - 성공 케이스")
    @ParameterizedTest(name = "set has {0}? {1}")
    @ValueSource(ints = {1,2,3})
    void containsSuccess(int expected){
        assertTrue(numbers.contains(expected));
    }

    @DisplayName("값이 존재하는지 확인 - 성공과 실패 케이스")
    @ParameterizedTest(name = "set has {0}? {1}")
    @CsvSource(value = {"1,true","2,true", "3,true", "4,false", "5,false"})
    void containsFail(int index, boolean expected){
        boolean actual = numbers.contains(index);
        assertThat(actual).isEqualTo(expected);
    }

}
