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

    @DisplayName("size 메소드 정상적으로 반환하는지 확인")
    @Test
    void sizeTest() {
        final int expectedSize = 3;

        int size = numbers.size();

        assertThat(size).isEqualTo(expectedSize);
    }

    @DisplayName("contains 메소드 정상적으로 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {

        boolean result = numbers.contains(input);

        assertThat(result).isTrue();
    }
}
