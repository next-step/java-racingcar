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

    @DisplayName("set 사이즈 테스트")
    @Test
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("값을 포함하고 있는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}
