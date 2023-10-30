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
    @DisplayName("중복되는 원소를 제외하는 set의 크기를 확인한다. ")
    void get_numbers_size() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("1, 2, 3이 set에 존재하는지 확인한다.")
    void exists_number_one_two_three(String input) {
        int intSource = Integer.parseInt(input);
        assertThat(numbers.contains(intSource)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("1, 2, 3 을 제외한 값은 set에 포함되지 않는다.")
    void exists_number_one_two_three2(String input, String expected) {
        int intSource = Integer.parseInt(input);
        assertThat(numbers.contains(intSource)).isEqualTo(Boolean.parseBoolean(expected));
    }
}
