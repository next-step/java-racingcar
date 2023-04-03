package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항3)_입력값에 따른 결과")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void name(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
