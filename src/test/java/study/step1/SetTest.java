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
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @DisplayName("요구사항1 : Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    void setSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3}) // three numbers
    @DisplayName("요구사항2 : Set의 contains메소드 활용하여 1,2,3 값이 존재하는지 테스트")
    void setContainsTest(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"}) //{"input,expected"...}
    @DisplayName("요구사항3 : 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트 테스트")
    void setContainsParameterizedTest(int input, boolean expected){
        //String actualValue = input.toLowerCase();
        assertEquals(expected, numbers.contains(input));
    }
}
