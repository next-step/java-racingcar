package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

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
    void testSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Nested
    @DisplayName("contains() 테스트")
    class ContainsTest {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("set에 포함되어 있는 경우 true를 반환한다.")
        void testOnlyTrueCase(int input) {
            assertThat(numbers.contains(input)).isTrue();
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("set에 포함되어 있는 경우 true를 그렇지 않은 경우 false를 반환한다.")
        void testVariousCase(int input, boolean expected) {
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }
    }
}
