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

public class SetCollectionTest {

    private static Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(11);
        numbers.add(28);
        numbers.add(33);
        numbers.add(42);
    }

    @Test
    @DisplayName("Set 의 크기를 확인하는 테스트")
    public void size(){
        assertThat(numbers.size()).isEqualTo(4);
    }


    @DisplayName("Set 의 contains() 메소드를 활용하여 값이 존재하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {11,28,33})
    void SetContainsNumbers(int number){
       assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set 의 contains() 메소드로 값이 존재 하면 true , 존재하지 않으면 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"11:true" ,"28:true","4:false","33:true","18:false"} , delimiter = ':')
    void SetContainsTest(int number , boolean check){
        assertThat(numbers.contains(number)).isEqualTo(check);
    }


}
