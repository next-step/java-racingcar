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

    @Test
    @DisplayName("사이즈를 확인할 수 있다.")
    void size() {
        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("숫자를 포함 여부를 알 수 있다.")
    @ValueSource(ints = {1, 2, 3})
    void contains(int given) {
        // when // then
        assertThat(numbers.contains(given)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자를 포함 여부를 알 수 있다.")
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    void contains(int given, boolean result) {
        // when // then
        assertThat(numbers.contains(given)).isEqualTo(result);
    }
}
