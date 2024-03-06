package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    
    boolean isContains(int a) {
        return numbers.contains(a);
    }

    //요구사항1
    @DisplayName("Set의 size()메소드를 이용하여 Set의 크기를 확인하는 학습 테스트 구현")
    @Test
    void checkSetSize() {

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    //요구사항2
    @DisplayName("중복된 테스트")
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    
    @DisplayName("ParameterizedTest를 이용하여 매개변수를 입력한 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsWithParameterizedTest(int input) {
        assertThat(isContains(input)).isTrue();
    }
    
    //요구사항3
    @DisplayName("CsvSource를 이용해, 각 케이스 별 기대값을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1==true","2==true","3==true","4==false","5==false"}, delimiterString = "==")
    void eachTestWithCsvSource(int i, boolean isTrue){
        assertThat(isContains(i)).isEqualTo(isTrue);
    }


}
