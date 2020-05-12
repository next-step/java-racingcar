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

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("size() 메소드는 Set의 크기를 반환")
    public void setSizeTest(){

        // when
        int numberSize = numbers.size();

        // then
        assertThat(numbers.isEmpty()).isFalse();
        assertThat(numberSize).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("contain() 메소드는 입력 값의 존재 유무를 반환")
    public void setContainTest(int testValues){
        // then
        assertThat(numbers.contains(testValues)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:false"}, delimiter = ':')
    @DisplayName("contain() 메소드는 입력 값의 존재 유무를 반환 (false 케이스 추가)")
    public void setContainMultiCaseTest(int testValue, boolean expected){
        // when
        boolean result = numbers.contains(testValue);

        // then
        assertEquals(result, expected);
    }
}
