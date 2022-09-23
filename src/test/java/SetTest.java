import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        // 기존 방식
//        numbers = new HashSet<>();
//        numbers.add(1);
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);

        // Set.of 이용 -> 중복 값에 대해서는 Exception 발생함
        numbers = Set.of(1, 2, 3);

        // addAll 메소드 이용 -> 파라미터가 Collection 형태여야 함
//        int[] intAry = new int[] {1, 1, 2, 3};
//        numbers = new HashSet<>();
//        numbers.addAll(Arrays.stream(intAry).boxed().collect(Collectors.toList()));
    }

    /**
     * 요구사항 1
     * Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
     */
    @Test
    @DisplayName("요구사항1")
    void setTestNo1(){
        // numbers의 크기가 3인지 확인
        assertThat(numbers).hasSize(3);
    }

    /**
     * 요구사항 2
     * Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
     * 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
     * JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
     * @param input 테스트를 ValueSource 에서 투입되는 int 값
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2")
    void setTestNo2(int input){
        // input value 가 numbers에 contains 되어있는지 확인
        assertThat(numbers).contains(input);
    }

    /**
     * 요구사항 3
     * 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
     * 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
     * @param input 콤마로 구분된 int가 있는 String
     * @param expected 예상 결과 (true, false)
     */
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    @DisplayName("요구사항3")
    void setTestNo3(String input, boolean expected){
        // input String을 ,로 분리
        String[] splitedInput = input.split(",");

        // 각 int String을 int 로 parse 후 numbers에 cotains 되어있는지 확인
        for(String intStr : splitedInput) {
            int value = Integer.parseInt(intStr);
            assertThat(numbers.contains(value)).isEqualTo(expected);
        }
    }

}
