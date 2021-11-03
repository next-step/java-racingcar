import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("Set 자료구조는 중복값이 들어가지 않으므로 size는 3이다.")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest(name = "{arguments}가 numbers(Set)에 존재한다.")
    void containsTest(int expected) {
        assertThat(numbers.contains(expected)).isTrue();
    }

}
