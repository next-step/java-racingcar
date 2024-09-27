package calculator;

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
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size()로 Set의 크기를 확인한다.")
    void size(){
//        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("ParameterizedTest를 통해 중복코드를 제거하고 contains()로 값이 존재하는지 확인한다.")
    void containsValueSource(int number) {
//        assertThat(numbers.contains(number)).isTrue();
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("ParameterizedTest를 통해 입력값에 따라 결과값이 다른 경우를 테스트한다.")
    void containsCsvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
