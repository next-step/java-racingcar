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
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 사이즈를 확인한다")
    void size() {
        assertThat(numbers.size()).isNotEqualTo(4);
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 구성요소를 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set의 구성요소별 결과값을 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
