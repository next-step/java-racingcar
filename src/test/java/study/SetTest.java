package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("Collection.size()로 Set의 요소 개수를 알 수 있다.")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.size()).isNotEqualTo(4);
    }

    @DisplayName("@ParameterizedTest를 활용하여, 주어진 소스 값에 대한 테스트로 중복코드를 제거할 수 있다.")
    @ParameterizedTest(name = "{index} => element={0}, expectedResult={1}")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void contains(int element, boolean expectedResult) {
        assertThat(numbers.contains(element)).isEqualTo(expectedResult);
    }
}
