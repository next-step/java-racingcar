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

public class SetCollectionTest {
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
    @DisplayName("요구사항1: Set의 사이즈는 3")
    void set_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2: 1,2,3이 set 내부에 있다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set_contains_1_2_3(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("요구사항3: 1,2,3은 set에 포함되지만, 4,5는 미포함된다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void set_contains_1_to_3_and_dont_have_4_and_5(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
