import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
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

    @DisplayName("SetCollection size() 테스트 : numbers의 사이즈는 3")
    @Test
    void size() {
        int expectedSize = 3;
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @DisplayName("SetCollection contains() 테스트")
    @ParameterizedTest(name = "{0}은/는 numbers에 존재 한다 -> true ")
    @ValueSource(ints = {1, 2, 3})
    void contains1(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("SetCollection contains() 테스트")
    @ParameterizedTest(name = "{0}은/는 numbers에 존재 한다 -> {1}")
    @CsvSource(value = {
            "1, true",
            "4, false",
            "6, false"
    })
    void contains2(int num, boolean expectedResult) {
        assertThat(numbers.contains(num)).isEqualTo(expectedResult);
    }
}
