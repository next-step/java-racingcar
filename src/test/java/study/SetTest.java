package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set size로 Set 크기 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("ParameterizedTest 사용해서 Set이 1,2,3을 포함하는지 확인 ")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTrueOnly(int number){
        assertThat(numbers).contains(number);
    }

    @DisplayName("ParameterizedTest CsvSource를 사용해서 Set이 1,2,3,4,5를 포함하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueAndFalse(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
