package learningTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    void test_requirement_1() {
        int expecting = 4;
        int result = numbers.size();

        assertThat(result).isEqualTo(expecting);
    }

    @Test
    void test_requirement_2_1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void test_requirement_2_2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:true", "5:false" }, delimiter = ':')
    void test_requirement_3(int input, Boolean expecting) {
        assertThat(numbers.contains(input)).isEqualTo(expecting);
    }

}
