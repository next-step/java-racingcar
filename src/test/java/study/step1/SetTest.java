package study.step1;

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
    void contains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }


    @Test
    @DisplayName("요구사항 1, Set 크기 확인하는 학습테스트")
    void setSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2, Set contains() 메소드를 활용해 1,2,3의 값이 존재하는지 확인하는 학습테스트")
    void setContainsWithParameterized(Integer number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3, @CsvSource를 활용하여 contains 메소드 1, 2, 3 값은 true, 4, 5 값은 false 가 반환되는 테스트")
    void setContainsWithParameterizedAndCsvSource(Integer number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
