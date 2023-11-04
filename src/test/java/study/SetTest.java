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
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Set 크기 확인 테스트")
    void setSizeCheckTest() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Set 값 존재 확인 테스트")
    @ParameterizedTest(name = "{displayName} {index} value={0}")
    @ValueSource(ints = {1, 2, 3})
    void setContainsTest(int input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("Set 값 예상 확인 테스트")
    @ParameterizedTest(name = "{displayName} {index} value={0}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContainsTest2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
