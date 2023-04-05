package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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


    @Nested
    @DisplayName("요구사항 1 - size")
    class Requirement01 {

        @Test
        @DisplayName("동일한 값을 넣어도 size는 늘어나지 않는다")
        void sizeTest() {
            assertThat(numbers).hasSize(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2 - contains")
    class Requirement02 {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("")
        void test01(int input) {
            assertThat(numbers.contains(input)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3 - contains")
    class Requirement03 {
        @ParameterizedTest
        @CsvSource(value = {"1 , true", "2 , true", "3 , true", "4 , false", "5 , false"}, delimiter = ',')
        @DisplayName("포함되지 않은 값을 인자로 넘기면 false가 리턴된다")
        void test01(int input, boolean expected) {
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }
    }

}
