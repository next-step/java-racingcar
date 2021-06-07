package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

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

    @DisplayName("입력값에 1, 2, 3이 포함된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containTest(int input) {
        Assertions.assertThat(numbers).contains(input);
    }

    @DisplayName("각각의 숫자는 참과 거짓을 가진다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void trueFalseTest(int input, boolean result) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(result);
    }
}

