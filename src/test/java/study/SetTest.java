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
    @DisplayName("Set Collection에 대한 학습 테스트 - 요구사항 1")
    void size() {
        System.out.println(numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set Collection에 대한 학습 테스트 - 요구사항 2")
    void contains(int i) {
        assertThat(numbers.contains(i)).isTrue();
    }
}