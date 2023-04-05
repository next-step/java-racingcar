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

    // Test Case 구현

    @Test
    @DisplayName("Set 사이즈 테스트 - 성공")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set item contain 테스트 - 성공")
    void containTest(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","2,true","3,true","4,false"})
    @DisplayName("Set item contain 테스트  - 성공")
    void containTest(int num, boolean expect) {
        assertThat(numbers.contains(num)).isEqualTo(expect);
    }
}
