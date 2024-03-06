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

    @DisplayName("요구사항 1 - string이 잘 split 되는지 확인한다.")
    @Test
    void checkSetSize() {

        int result = numbers.size();
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("요구사항 2 - 1,2,3 값이 set에 존재하는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void checkSetValue(int value) {

        boolean result = numbers.contains(value);
        assertThat(result).isTrue();
    }

    @DisplayName("요구사항 3 - 1,2,3 값이 set에 존재하는지 확인한다. 다른 결과가 포함되어도 테스트가 가능해야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "4,false"})
    void checkSetValueTrueOrFalse(int value, boolean solution) {

        boolean result = numbers.contains(value);
        assertThat(result).isEqualTo(solution);
    }
}
