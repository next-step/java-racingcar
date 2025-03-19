package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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
    @DisplayName("요구사항1: set size")
    void req1() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항2: ParameterizedTest - ValueSource")
    @ValueSource( ints = {1, 2, 3} )
    void req2(int input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @DisplayName("요구사항3: ParameterizedTest - CsvSource")
    @CsvSource(value =  {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    void req3(int i, boolean e) {
        assertThat(numbers.contains(i)).isEqualTo( e );
    }
}
