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

    @Test
    @DisplayName("Set 콜렉션의 size 메소드는 콜렉션에 있는 데이터 수를 리턴한다")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("@ParameterizedTest 사용하여 콜렉션 안의 데이터를 일괄로 확인할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void parameterizedTest(int data){
        assertThat(numbers.contains(data)).isTrue();
    }

    @DisplayName("@CsvSource 사용하여 입력 값에 따라 결과값이 다른 경우에 대한 확인이 가능하다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void csvSource(int data, boolean expected){
        assertThat(numbers.contains(data)).isEqualTo(expected);
    }
}
