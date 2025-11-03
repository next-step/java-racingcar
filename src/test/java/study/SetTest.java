package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size()로 Set의 크기를 확인한다.")
    void size() {
        assertThat(numbers.size()).isNotEqualTo(4);
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains()로 요소가 존재하는지 확인한다.")
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }
}
