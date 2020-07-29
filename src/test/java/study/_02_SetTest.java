package study;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class _02_SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항1-size")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2-contains")
    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    void contains(int n) {
        assertThat(numbers.contains(n)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value={"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void contains2(int n, boolean result) {
        assertThat(numbers.contains(n)).isEqualTo(result);
    }
}
