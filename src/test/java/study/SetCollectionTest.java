package study;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {
//    Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @DisplayName("Set 사이즈 확인")
    @Test
    void checkSetSizeTest() {
        Set<Integer> numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        int setSize = numbers.size();

        Assertions.assertThat(setSize).isEqualTo(3);
    }

//    Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
//    구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
//    JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

    @DisplayName("중복 코드 없이 set 내의 값 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void checkSetValueTest(int input) {
        Set<Integer> numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Assertions.assertThat(numbers).contains(input);
    }

//    요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
//    예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

    @DisplayName("입력값에 따른 다른 결과값을 나타내는 테스트 작성")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkSetValueTest2(int input, boolean expected) {
        Set<Integer> numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
