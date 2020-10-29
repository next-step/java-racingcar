package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Set의 사이즈 확인")
    void sizeTest() {

        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("Set에 1,2,3 이 포함되어있는지 확인 하는 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set에 1,2,3 이 포함되어있는지 확인 하는 테스트 - ParameterizedTest")
    @ValueSource(ints = {1, 2, 3})
    void contains1(Integer input) {
        System.out.println(input);
        assertThat(numbers.contains(input)).isTrue();
    }
}
