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

    @DisplayName("Set 사이즈가 3인지 테스트")
    @Test
    void confirm_set_size() {
        // assertion
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("Set이 1,2,3을 포함하고 있는지 테스트")
    @Test
    void confirm_set_contains_from_one_to_three() {
        // assertion
        assertThat(numbers).contains(1, 2, 3);
    }

    @ParameterizedTest(name = "Set이 input을 포함하고 있는지 테스트 - input: {0}")
    @ValueSource(ints = {1, 2, 3})
    void confirm_set_contains_input(int input) {
        // assertion
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest(name = "Set이 input 포함/비포함 유무 테스트 - input: {0}, expected: {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void confirm_set_contains_or_not(String inputStr, String expectedStr) {
        // assertion
        assertThat(numbers.contains(Integer.valueOf(inputStr)))
                .isEqualTo(Boolean.valueOf(expectedStr));
    }
}
