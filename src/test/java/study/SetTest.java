package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection 테스트")
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
    @DisplayName("Set 의 크기를 확인한다.")
    void setSize(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "[{index}] {0} 은 Set 에 포함되어있다. ")
    @ValueSource(ints = {1,2,3})
    @DisplayName("set 에 존재하는 값들을 Contains 로 확인한다.")
    void checkSetContains(int element){
        assertThat(numbers.contains(element)).isTrue();
    }

    @ParameterizedTest(name = "[{index}] {0} 값이 들어있는지 검증한 결과 값은? : {1} ")
    @CsvSource(value = {"1:true","2:true","3:true","4:false"}, delimiter = ':')
    @DisplayName("set 에 존재하지 않는 값을 포함한 테스트")
     void checkSetContainsWithIncludingFalseValue(int element, Boolean expect){
        assertThat(numbers.contains(element)).isEqualTo(expect);
    }

}
