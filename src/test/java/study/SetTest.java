package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    //요구사항1
    @Test
    @DisplayName("배열의 사이즈 확인")
    void setSize(){
        numbers.size();
    }

    //요구사항2
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("배열에 1,2,3여부 확인")
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    //요구사항3
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("1,2,3 : true, 4,5 : false")
    void contains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}