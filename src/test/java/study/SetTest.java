package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
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
    @DisplayName("size() 메서드를 활용하여 중복된 값을 제외하고 3을 출력한다.")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("contains() 메소드를 활용하여 1, 2, 3의 존재 유무를 확인한다.")
    @ValueSource(strings = {"1", "2", "3"})
    void contains(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

}
