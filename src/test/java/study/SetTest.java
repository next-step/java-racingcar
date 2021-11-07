package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    void sizeTest() {
        assertThat(3).isEqualTo(numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void valueSourceTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
    void csvSourceTest(int number, boolean exptected) {
        assertEquals(exptected, numbers.contains(number));
    }
}
