import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @DisplayName("size 메소드 활용하여 Set의 크기를 확인한다.")
    @Test
    void sizeTest() {
        // given
        int expected = 3;

        // when
        int sut = numbers.size();

        // then
        assertThat(sut).isEqualTo(expected);
    }

    @DisplayName("contains 메소드 활용해 값이 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }
}
