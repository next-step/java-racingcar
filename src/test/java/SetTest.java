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

    @DisplayName("set의 크기를 확인할 수 있다.")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요소가 존재하는지 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsExistingElements(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @DisplayName("요소의 존재 여부를 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithBothCases(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}
