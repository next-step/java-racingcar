package step1.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SetTest {
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
    @DisplayName("요구 사항 1 - Set 크기 확인 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구 사항 2 - contains()를 활용하여 Set 내 값이 존재하는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains(Integer input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라 결과 값이 다른 경우")
    @CsvSource(value = {"1:true", "2:true", "5:false", "3:true", "8:false"}, delimiter = ':')
    void check_if_contains(Integer input, boolean expected) {
        boolean actualValue = numbers.contains(input);
        assertEquals(expected, actualValue);
    }

}