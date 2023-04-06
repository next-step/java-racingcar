package step1.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

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

    // Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @Test
    void size() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "contains Test - (input: {0})")
    @ValueSource(ints = {1,2,3})
    void contains(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest(name = "not contains Test - (input: {0})")
    @ValueSource(ints = {4,5,6})
    void not_contains(int input) {
        assertThat(numbers).doesNotContain(input);
    }

}
