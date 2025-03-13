package study.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Nested
    class requirements1 {
        @Test
        void setSize() {
            assertEquals(3, numbers.size());
        }
    }

    @Nested
    class requirements2 {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        void parameterizedValueScoreTest(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Nested
    class requirements3 {
        @ParameterizedTest
        @CsvSource({
                "1, true",
                "2, true",
                "3, true",
                "4, false",
                "5, false"
        })
        void parameterizedCsvSourceTest(int number, boolean expected) {
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }
    }
}
