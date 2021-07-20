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
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void 요구사항1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest 활용 중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 요구사항2(int index) {
        assertTrue(numbers.contains(index));
    }

    @DisplayName("CsvSource 활용")
    @ParameterizedTest
    @CsvSource(value = {"1-true", "0-false", "2-true", "4-false"}, delimiter = '-')
    void 요구사항3(int index, boolean expect){
        assertEquals(numbers.contains(index),expect);
    }

}
