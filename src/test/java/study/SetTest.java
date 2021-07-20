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
    @DisplayName("numbers size() 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains()를 사용하여 numbers에 값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers).contains(number);
    }


    @DisplayName("contains()를 사용하여 numbers에 값이 존재 여부-true/false- 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(int number, boolean result) {
        boolean actualResult = numbers.contains(number);
        assertThat(actualResult).isEqualTo(result);
    }


}
