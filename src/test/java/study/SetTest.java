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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
    @Test
    @DisplayName("Set의 크기를 확인")
    void size(){
        // int result = numbers.size();
        // assertThat(result).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest()
    @DisplayName("Set에 1, 2, 3의 값이 존재하는지를 확인")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number){
        //assertThat(numbers.contains(number)).isTrue();
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @DisplayName("Set에 존재하는지 입력 값에 따라 다른 결과 값을 반환")
    @CsvSource(value =  { "1:true" ,"2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
    void contains(int number, boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
