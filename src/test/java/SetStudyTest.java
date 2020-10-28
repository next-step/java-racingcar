import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetStudyTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
    public void contains(int what, boolean expected) {
        assertThat(numbers.contains(what)).isEqualTo(expected);
    }

}
