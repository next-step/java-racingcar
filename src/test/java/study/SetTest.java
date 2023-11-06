package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
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

    // Test Case 구현
    @Test
    @DisplayName("Set의 크기를 확인")
    void size_확인() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("값 존재 유무 확인")
    void contains_확인1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("값 존재 유무 확인 소스중복 제거")
    @ValueSource(ints = {1,2,3})
    void contains_확인2(int input) {
            assertThat(numbers.contains(input)).isTrue();
    }

//    요구사항 3
//    요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
//    예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
    @DisplayName("원하는 값에 대한 기대값 확인")
    @ParameterizedTest
    @CsvSource(value = {"1|true", "2|true", "3|true", "4|false", "5|false"}, delimiter = '|')
    void contains_확인3(int input, String expected) {
        String result = String.valueOf(numbers.contains(input));
        assertThat(result).isEqualTo(expected);
    }
}
