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
    @DisplayName("size() 로 Set 의 크기를 구 할 수 있다")
    void requirement1(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("contains() 로 특정 element 가 Set 에 포함되어 있는지 알 수 있다")
    void requirement2(Integer number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true", "3:true", "4:false", "5:false"},delimiter = ':')
    void requirement3(Integer number, Boolean expected){
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
