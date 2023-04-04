package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("Set size() 메소드를 활용해 Set 크기를 확인할 수 있다")
    @Test
    void givenSetWhenUsingMethodSizeThenReturnSize() {
        // given
        int expected = 3;

        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("parameterizedTest 활용하여 Set 포함된 값인지 확인할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void givenSetWhenUsingMethodContainsThenReturnTrue(String input) {
        // given
        int number = Integer.parseInt(input);

        // when
        boolean result = numbers.contains(number);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void givenSetWhenUsingMethodContainsThenReturnTrueOrFalse(String input, String expected) {
        // given
        int number = Integer.parseInt(input);
        boolean result = Boolean.parseBoolean(expected);

        // when
        boolean contains = numbers.contains(number);

        assertThat(contains).isEqualTo(result);
    }
}