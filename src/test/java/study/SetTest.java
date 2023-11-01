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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("요구사항1 - size() 메소드로 Set 크기 확인 테스트")
    void sizeTest(){
        int numbersSize = numbers.size();
        assertThat(numbersSize).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 - ParameterizedTest를 활용한 contains() 메소드로 값이 존재하는지 테스트")
    void containsTest(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("요구사항3 - 입력 값에 따라 결과 값이 다른 경우를 구현한 contains 메소드 테스트")
    void containsTest2(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
