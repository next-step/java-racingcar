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
    @DisplayName("요구사항1 - SET size 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항2 - 요소확인 NormalCase")
    @ValueSource(ints = {1,2,3})
    void contains_NormalCase(int targetInt) {
        assertThat(numbers.contains(targetInt)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항2 - 요소확인 FailCase")
    @ValueSource(ints = {4,5})
    void contains_failCase(int targetInt) {
        assertThat(numbers.contains(targetInt)).isFalse();
    }
}
