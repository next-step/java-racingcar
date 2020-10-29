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
    @DisplayName("size() 테스트")
    void sizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("ValueSource 어노테이션을 활용하여 컬렉션이 값을 포함하는지 테스트")
    void containsValue_WithValueSourceTest(int input){
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("CsvSource 어노테이션을 활용하여 컬렉션에 값 포함 여부 테스트")
    void containsValue_ShouldReturnBooleanValueWithCsvSourceTest(String intInput, String booleanInput){
        boolean actual = numbers.contains(Integer.parseInt(intInput));
        boolean expected = Boolean.parseBoolean(booleanInput);
        assertThat(actual).isEqualTo(expected);

    }

}
