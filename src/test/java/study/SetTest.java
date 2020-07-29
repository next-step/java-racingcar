package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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
    public void size() {
        Assertions.assertThat(numbers).hasSize(3);
        Assertions.assertThat(numbers.isEmpty()).isFalse();

    }

    @ParameterizedTest
//    @ValueSource(ints = {1,2,3})
    @CsvSource(value = {"1:true", "3:true", "4:false"}, delimiter = ':')
    public void contains(int number, boolean result) {
        Assertions.assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
