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
    @DisplayName("set size의 메소드 활용하여 크기를 확인")
    void set_requireStep1(){
        int numbersSize = numbers.size();
        assertThat(numbersSize).isEqualTo(3);
    }

    @Test
    @DisplayName("set의 contains를 이용한 값 테스트")
    void set_requireStep2(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("set 중복 Test코드 제거 테스트")
    void setNumberValues(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("입력값에 따라 결과값이 다른경우에 대한 테스트")
    @ParameterizedTest(name ="{displayName} 입력값")
    @CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"},delimiter = ',')
    void set_requireStep3(int number,boolean flag){
        boolean result = numbers.contains(number);
        org.junit.jupiter.api.Assertions.assertEquals(flag,result);
    }
}
