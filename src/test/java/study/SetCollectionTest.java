package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @DisplayName("Set의 싸이즈 확인")
    @Test
    void verifySetSize() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @DisplayName("Set에 1,2,3이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void verifySetContainingOneTwoThree(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("Set에 특정 데이터들이 존재하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3 : true", "4,5 : false"}, delimiter = ':')
    void verifySetData(String input, boolean expected) {
        String[] inputArray = input.split(",");

        boolean result = Arrays
                .stream(inputArray)
                .allMatch(num -> numbers.contains(Integer.parseInt(num)));

        assertThat(result).isEqualTo(expected);
    }
}
