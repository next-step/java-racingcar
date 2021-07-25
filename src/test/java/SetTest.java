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
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("Set Size 테스트")
    void size() {
        //then
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("Set contains 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains01(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("Set contains true, false 반환 테스트")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,true", "5,false"})
    void contains02(int input, boolean expected) {
        boolean actual = numbers.contains(input);
        assertThat(actual).isEqualTo(expected);
    }
}
