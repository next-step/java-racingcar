package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    @Test
    @DisplayName("요구사항 1 : size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현")
    void size() {
    	assertThat(numbers.size()).isEqualTo(3);
    }
    
    @DisplayName("요구사항 2 : contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void contains(int num) {

    	assertThat(numbers.contains(num)).isTrue();
    	
    	//@Test와 @ParameterizedTest는 동일사용X 어떤걸 테스트할지 모르기때문에 오류남....
        //assertThat(numbers.contains(1)).isTrue();
        //assertThat(numbers.contains(2)).isTrue();
        //assertThat(numbers.contains(3)).isTrue();
    }
    
    @ParameterizedTest
    @DisplayName("요구사항 3 : 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void checkParameterDiff(int input, boolean expected) {
    	assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}