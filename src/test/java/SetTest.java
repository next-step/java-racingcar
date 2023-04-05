import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Set size 체크")
    void size() {
        int expected = 3;
        int result = numbers.size();

        assertThat(result).isEqualTo(expected);
    }

    @Nested
    @DisplayName("contains 테스트")
    class contains {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("set에 있는 요소만 체크")
        void contains(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("set에 없는 요소 체크")
        void containsNotExist(int number, boolean result) {
            assertThat(numbers.contains(number)).isEqualTo(result);
        }
    }
}
