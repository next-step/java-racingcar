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
    @DisplayName("Set의 크기 확인")
    void setSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("값 존재 확인하는 테스트")
    void contains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("값 존재 확인하는 테스트 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContains_ShouldReturnTrueForSetCollection(int index){
        assertTrue(numbers.contains(index));
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true","3:true", "4:false", "5:false"}, delimiter = ':')
    void ShouldGenerateTheExpected_BooleanTrueOrFalse(int input, boolean expected){
        boolean actualValue = numbers.contains(input);

        assertThat(actualValue).isEqualTo(expected);
    }
}
