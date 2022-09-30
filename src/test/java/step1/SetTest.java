package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(1, 1, 2, 3));
    }

    // Test Case 구현
    @Test
    @DisplayName("set의 사이즈 확인")
    void test1() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("set의 value값 확인")
    @ValueSource(ints = {1, 2, 3})
    void test2(int value) {
        assertThat(numbers).containsAll(Arrays.asList(1, 2, 3));
    }

    @ParameterizedTest
    @DisplayName("set에 포함된 값과 포함되지 않은 값에 대해 contains 메서드로 확인")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test3(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
