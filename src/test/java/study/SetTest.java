package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        assertThat(numbers).size().isNotEqualTo(4);
        assertThat(numbers).size().isEqualTo(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

}
