package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("Set의 크기 구하기")
    void mission1() {
        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("@ValueSource 활용")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void mission2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("@CsvSource 활용")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void mission3(int number, boolean expected) {
        assertThat(expected).isEqualTo(numbers.contains(number));
    }

}
