package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SetTest {
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
    @DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인한다.")
    public void test_set_size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("Set 의 contains() 메소드를 활용해 값이 존재하는지를 확인한다.")
    public void test_set_contains(final int value, final boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
