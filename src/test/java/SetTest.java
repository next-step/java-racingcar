import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("Set의 사이즈 구하기")
    void getSizeOfSet() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 2, 3})
    @DisplayName("value Source를 이용한 Set contains 테스트")
    void hasNumberUsingValueSource(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Csv Source를 이용한 Set contains 테스트")
    void hasNumberUsingCsvSource(String input, String expected) {
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(
            Boolean.parseBoolean(expected));
    }
}