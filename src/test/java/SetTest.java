import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
    }

    @Test
    void size_값_테스트() {
        assertThat(numbers.size()).isEqualTo(3);
    }
}
