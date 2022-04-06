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
    @DisplayName("size")
    void requirementFirst() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("contains - input")
    @ValueSource(ints = {1, 2, 3})
    void requirementSecond(int input) {
        assertThat(numbers.contains(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("contains - input/expected")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void requirementThird(String input, String expected) {
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(expected));
    }
}
