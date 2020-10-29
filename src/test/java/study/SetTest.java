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

public class SetTest {
    private Set<Integer> numbers;

    // @Test 메소드 실행되기전 수행
    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @Test
    @DisplayName("요구사항 1 : Set의 size() 메소드 활용")
    void sizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }


    @DisplayName("요구사항 2 : Set의 contains() 메소드 활용")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항 3 : 요구사항 2 + 입력 값에 따른 boolean 형 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true","4,5:false"}, delimiter = ':')
    void containsReturnTest(String input, String expected){
        boolean exp = Boolean.parseBoolean(expected);
        String[] actualValue = input.split(",");

        for(String strVal : actualValue){
            int intVal = Integer.parseInt(strVal);
            assertEquals(numbers.contains(intVal),exp);
        }

    }


}
