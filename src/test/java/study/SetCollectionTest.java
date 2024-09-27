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

public class SetCollectionTest {

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
    @DisplayName("numbers size 확인하기")
    void charAt() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("numbers 값 일치 여부 확인하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }


    @DisplayName("numbers 값 포함 여부 확인하기")
    @ParameterizedTest
    @CsvSource({
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false",
    })
    void numbersContains(int value, boolean result) {
        boolean contains = numbers.contains(value);
        assertThat(contains).isEqualTo(result);
    }


}
