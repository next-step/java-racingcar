package study.step1;

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
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @DisplayName("요구사항1, Set 사이즈 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("요구사항2, Set 포함여부 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void contains(int param) {
        assertTrue(numbers.contains(param));
    }

    @DisplayName("요구사항3, Set 포함여부 true, false 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "5:false"}, delimiter = ':')
    void returnCheck(String input, String expected) {
        assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.valueOf(expected));
    }
}
