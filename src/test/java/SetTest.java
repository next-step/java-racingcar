import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인")
    void size() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("여러 파라미터를 테스트 할때 중복 코드 발생, @ValueSource를 활용하여 제거 후 확인")
    void containsUsingValueSource(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("입력 값에 따라 결과 값이 다른 경우 확인")
    void contains(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }


}
