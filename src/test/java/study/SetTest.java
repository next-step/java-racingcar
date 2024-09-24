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
    @DisplayName("Set의 size 메소드를 이용하여 크기를 확인하는 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "{0}을/를 포함하고 있는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains 메소드를 이용하여 포함 여부를 확인하는 테스트1")
    void contains1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{0}을/를 포함하고 있는지 확인하는 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set의 contains 메소드를 이용하여 포함 여부 확인하는 테스트2")
    void contains2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
