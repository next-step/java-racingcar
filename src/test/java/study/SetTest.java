package study;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

/**
 * Set Collection에 대한 학습 테스트
 * 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.
 *
 * 요구사항 1
 * Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
 *
 * 요구사항 2
 * Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
 * 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
 * JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
 *
 * 힌트
 * Guide to JUnit 5 Parameterized Tests
 *
 * 요구사항 3
 * 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
 * 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
 * 힌트
 * Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.
 *
 */
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
    @DisplayName("SetTest size()")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("SetTest contains()")
    void contains(int numParam) {
        assertThat(numbers.contains(numParam)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"123:45"}, delimiter = ':')
    @DisplayName("SetTest csvSourceContain()")
    void csvSourceContain(String numParam1, String numParam2) {
        for (int i=0; i<numParam1.length(); i++){
            assertThat(numbers.contains(Character.getNumericValue(numParam1.charAt(i)))).isTrue();
        }
        for (int j=0; j<numParam2.length(); j++){
            assertThat(numbers.contains(Character.getNumericValue(numParam2.charAt(j)))).isFalse();
        }
    }
}
