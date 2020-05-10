package study.nextstep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Set Collection에 대한 학습 테스")
public class SetCollectionStudyTest {
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
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    public void Req1_testSizeMethod2ConfirmSizeOfSet(){
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("contains() 메소드를 활용해 1,2,3 값이 존재하는지 확인하는 테스트")
    public void Req2_testContainsMethod2ExistsOfNumbers(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("contains() 메소드 테스트에서 결과 값이 다른 경우도 존재하는 테스트")
    public void Req3_testContainsMethod2ExistsOfNumbersOrNot(String input, String expected){
        assertThat(Boolean.toString(numbers.contains(Integer.parseInt(input)))).isEqualTo(expected);
    }
}
