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

    @Test
    void set_size_test() {
        // given
        final int expected = 3;

        // when
        final int setSize = numbers.size();

        // then
        assertThat(setSize).isEqualTo(expected);
    }
    
    @DisplayName("값이 set에 존재하는지 테스트")
    @ParameterizedTest(name = "값: {0}")
    @ValueSource(ints = {1,2,3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }
}
