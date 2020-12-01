import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("numbers set 사이즈 확인")
    void set_size_test() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("numbers set 사이즈 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_contains_test(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("numbers set 사이즈 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @ParameterizedTest
    void set_contains_test(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
