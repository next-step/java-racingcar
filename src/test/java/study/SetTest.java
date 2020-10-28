package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private final Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));

    @Nested
    @DisplayName("contains")
    class Contains {
        @Test
        void not_using_ParameterizedTest() {
            assertThat(numbers.contains(1)).isTrue();
            assertThat(numbers.contains(2)).isTrue();
            assertThat(numbers.contains(3)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void should_return_true_if_set_contain_input_number(final int input) {
            assertThat(numbers.contains(input)).isTrue();
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
        void should_return_true_if_set_contain_input_number(final int input, final boolean expected) {
            //when
            final boolean result = numbers.contains(input);

            //then
            assertThat(result).isEqualTo(expected);
        }
    }
}
