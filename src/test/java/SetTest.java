import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("Set의 size()를 배운다.")
    @Test
    void size_SetGiven_ReturnSetSize() {
        // when
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains()를 배운다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains_SetGiven_ReturnTrue(int number) {
        // when
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set의 contains()에서 예외가 발생하는 조건을 배운다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_NumberAndExpectedGiven_ShouldReturnTrue(int number, boolean expected) {
        // given
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
