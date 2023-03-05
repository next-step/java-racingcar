package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    
    // Test Case 구현
    // 요구사항 1
    // Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @Test
    void sizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    // 요구사항 2
    /*     Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
    JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다. */
    /* @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    } */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int member) {
        assertThat(numbers.contains(member)).isTrue();
    }

    /*요구사항 3
    요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
            힌트
    Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.*/
    @ParameterizedTest
    @CsvSource(value = {"1:2", "3:4", "5:6"}, delimiter = ':')
    void memberTestCSV(int input, String expected) {
        System.out.println(input);
        assertThat(numbers.contains(input)).isTrue();
    }

}