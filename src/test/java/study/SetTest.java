package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
    void setSizeCheck() {
        int size = numbers.size();

        Assertions.assertThat(size).isEqualTo(3);
    }
}
