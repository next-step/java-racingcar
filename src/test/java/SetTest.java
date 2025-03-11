import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("Set.size() 메서드 활용 테스트")
    void request1() {
        int expectedSize = 3;
        int actualSize = numbers.size();

        Assertions.assertThat(actualSize).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @DisplayName("Set.contains() 메서드 활용 테스트")
    @ValueSource(ints = {1, 2, 3})
    void request2(int number) {
        Assertions.assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("CsvSource를 활용한 테스트")
    @CsvSource(value={"1, true", "2, true", "3, true", "4, false", "5, false"}, delimiter = ',')
    void request3(int number, boolean expected) {
        Assertions.assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}