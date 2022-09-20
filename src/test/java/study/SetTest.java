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

    @DisplayName("Set 크기를 반환한다")
    @Test
    void size() {
        int result = numbers.size();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Set 안에 특정 요소가 있는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains1(Integer element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @DisplayName("Set 안에 특정 요소가 있는지 확인한다 2")
    @ParameterizedTest
    @CsvSource(value = {
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false",
    })
    void contains2(Integer element, Boolean expected) {
        boolean result = numbers.contains(element);
        assertThat(result).isEqualTo(expected);
    }
}
