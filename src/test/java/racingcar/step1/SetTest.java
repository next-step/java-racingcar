package racingcar.step1;

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
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1 - set 크기")
    void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2 - set 결과값 동일한 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항3 - set 결과값 다른 경우")
    @ParameterizedTest
    @CsvSource(value = {"1 : true", "2 : true", "3 : true", "4 : false", "5 : false"}, delimiter = ':')
    void notContains(int number, boolean expected) {
        assertThat(expected).isEqualTo(numbers.contains(number));
    }

}
