import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set")
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
    @DisplayName("numbers는 요소 3개를 가지고 있다.")
    void size() {
        // when & then
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("numbers에 1, 2, 3이 존재한다.")
    void contains01(final int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("numbers에 1, 2, 3은 존재하고 4, 5는 존재하지 않는다.")
    void contains02(final int number, final boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
