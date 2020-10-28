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
    @DisplayName(value = "HashSet의 size() 테스트")
    public void size() throws Exception {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName(value = "HashSet의 contains() 및 ValueSource 테스트")
    public void isContains_ShouldReturnTrueForHashSetNumber(int number) throws Exception {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName(value = "HashSet의 contains() 및 CsvSource 테스트")
    public void isContains_ShouldGenerateTheExpected(int number, boolean expected) throws Exception {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
