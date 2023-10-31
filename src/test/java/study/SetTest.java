package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name="Set에 있는 값인 {0}를 contains하면 True를 반환")
    @ValueSource(ints = {1, 2, 3})
    void containsTrue(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name="Set에 없는 값인 {0}를 contains하면 False를 반환")
    @ValueSource(ints = {4, 10, 12})
    void containsFalse(Integer input) {
        assertThat(numbers.contains(input)).isFalse();
    }

    @ParameterizedTest(name="값{0}의 Set 존재여부를 contains로 확인하며 {1}를 반환")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(Integer input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
