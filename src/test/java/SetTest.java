import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
    @DisplayName("size()메서드로 Set의 size 확인한다")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("특정 데이터 포함만 확인한다")
    @ValueSource(ints = {1,2,3})
    void onlyContains(int input) {
        assertThat(numbers.contains(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("특정 데이터 포함시 true, 미포함시 false를 반환한다")
    @CsvSource(value = {"1: true", "2: true", "3: true", "4: false", "5: false"}, delimiter = ':')
    void hasElement(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
