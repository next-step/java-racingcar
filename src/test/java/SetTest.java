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
    @DisplayName("Set의 크기 확인 테스트")
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains 메소드 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void contains(int argument) {
        assertTrue(numbers.contains(argument));
    }

    @DisplayName("Set의 contains 결과값이 다른 경우 테스트")
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    public void containsWithScenario(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }
}
