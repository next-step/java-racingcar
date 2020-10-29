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
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Origin")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("요구사항 1 : Set 의 size() 메소드를 활용해 Set 의 크기를 확인")
    void setSize() {
        int expected = 3;
        assertThat(numbers.size()).isEqualTo(expected);
    }

    @DisplayName("요구사항 2 : ParameterizedTest 를 이용한 Set 원소 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 } )
    void isSetContains(int input) {
        // contains 메소드 결과 값이 true 인 경우만 테스트 가능하다.
        assertTrue(numbers.contains(input));
    }

    // Csv(comma-separated values) 몇 가지 필드를 쉼표(,)로 구분한 텍스트 데이터 및 텍스트 파일 (wiki)
    @DisplayName("요구사항 3 : 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현.")
    @ParameterizedTest
    @CsvSource(value = {"true:false", "4:false", "5:false"}, delimiter = ':')
    void test(String input, Boolean expected) {
        // set.contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트
        // CsvSource 의 형변환이 어떻게 되고 있는지 궁금
        assertEquals(expected, numbers.contains(input));
    }
}
