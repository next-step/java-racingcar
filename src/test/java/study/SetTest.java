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

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size()를 사용해서 크기를 확인하는 테스트.")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("@ParameterizedTest를 이용해서 Set안에 있는 값을 반복적으로 체크하는 테스트.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int targetNumber) {
        assertThat(numbers.contains(targetNumber)).isTrue();
    }

    @DisplayName("@ParameterizedTest를 이용해서 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트.")
    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    void csvTest(String input, String expected) {
        assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.valueOf(expected));
    }
}
