package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("Set 클래스의 size 메소드에 대해 테스트한다.")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false"})
    @DisplayName("Set 클래스의 contains 메소드에 대해 테스트한다.")
    void contains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
