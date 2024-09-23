package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("numbers의 사이즈를 확인하는 테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("numbers에 1, 2, 3이 포함되어 있는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void checkNumbersItem(String input) {
        int number = Integer.parseInt(input);
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("numbers에 1, 2, 3일 경우 true, 4,5일 경우 false를 반환하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkNumbersItem(String input, boolean expected) {
        int number = Integer.parseInt(input);
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
