package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1)_SetSize")
    void count_check() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2)_중복 코드 제거")
    @ParameterizedTest(name = "numbers contains {0}")
    @ValueSource(ints = {1,2,3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항3)_입력값에 따른 결과")
    @ParameterizedTest(name = "{index} ==> {0} partner is {1}")
    //@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @MethodSource("parameter")
    void name(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

    static Stream<Arguments> parameter(){
        return Stream.of(
                arguments(1,true)
                ,arguments(2,true)
                ,arguments(3,true)
                ,arguments(4,false)
                ,arguments(5,false)
        );
    }
}
