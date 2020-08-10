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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach // 각각의 Test 메소드가 실행될 때 호출되는 메소드로 각각의 메소드가 실행 전에 호출되어 처리되는 것들
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @DisplayName("Set의 크기를 확인하는 Test")
    @Test
    public void req1() {
        assertEquals(3,numbers.size());
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1,2,3 의 값이 존재하는지 확인하는 Test")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void req2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
    public void req3(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

    /**********************
     * 강의 내용 정리
     **********************/
    @Test
    public void size() {
        assertThat(numbers).hasSize(3);
        assertThat(numbers.isEmpty()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3}) // 해당 어노테이션에 지정한 배열을 파라미터 값으로 순서대로 넘겨준다.
    public void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':') // csv 포맷으로 테스팅을 편리하게 진행할 수 있다.
    public void contains(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}