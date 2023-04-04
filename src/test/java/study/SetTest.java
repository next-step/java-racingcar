package study;

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
    @DisplayName("numbers의 사이즈를 확인한다")
    void setSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("numbers가 inputs 값을 포함하고있는지 확인한다")
    void setContains(int inputs) {
        assertThat(numbers.contains(inputs)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    @DisplayName("numbers가 inputs 값을 포함하고있는지 expected 결과로 확인한다")
    void setContains2(String input, String expected) {
        int value = Integer.parseInt(input);
        boolean result = Boolean.parseBoolean(expected);

        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
