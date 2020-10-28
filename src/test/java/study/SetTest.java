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

    // Test Case 구현
    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void check_size_of_set_is_equal_to() {
        assertThat(numbers.size())
                .isEqualTo(3)
                .isGreaterThan(2);
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void check_size_of_set_with_is_not_equal_to() {
        assertThat(numbers.size())
                .isNotEqualTo(4)
                .isLessThan(4);
    }

    @ParameterizedTest
    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.")
    @ValueSource(ints = {1,2,3})
    void contains(int input_number) {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
        assertTrue(numbers.contains(input_number));
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다. " +
            "예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, " +
            "4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void test_contains_csv_source(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }
}
