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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test @DisplayName("size()메서드는 numbers set의 크기를 반환한다")
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("contains()메서드는 Set에서 그 값이 존재하는지 확인하는 boolean 값을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_return_true(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }
}
