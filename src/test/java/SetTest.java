import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    /**
     * Request 1 : Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현
     */
    @Test
    @DisplayName("Set의 사이즈 구하기")
    void sizeTest() {
        Assertions.assertAll(
            () -> assertThat(numbers.size()).isEqualTo(3),
            () -> assertThat(numbers).containsExactly(1, 2, 3)
        );
    }

    /**
     * Request 2 : Set의 contains() 메소드를 이용해 1,2,3의 값이 존재하는지를 확인하는 학습테스트를 구현하려 한다.
     * 구현하고 보니, 다음과 같이 중복 코드가 계속해서 발생한다.
     * JUnit의 ParameterizedTest를 활용해 중복 코드를 제거한다.
     */
    @DisplayName("ValueSource를 이용한 ParameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTestWithValueSource(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    /**
     * Request 3 : 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
     * 예를 들어 1,2,3 값은 contains 메소드 실행결과 true, 4,5 값을 넣으면 false가 반환되는 테스트를 하나의 Test Case로 구현한다.
     */
    @DisplayName("CsvSource를 이용한 ParameterizedTest")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void parameterizedTestWithCsvSource(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
