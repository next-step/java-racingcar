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

    @DisplayName("size()는 주어진 Set의 사이즈를 반환한다")
    @Test
    void size() {
        //given
        int expectedSize = 3;

        //when
        int result = numbers.size();

        //then
        assertThat(result).isEqualTo(expectedSize);
    }

    @DisplayName("주어진 Set에 1, 2, 3의 값이 존재한다.")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void contains(int element) {
        //then
        assertThat(numbers).contains(element);
    }

    @DisplayName("주어진 Set에 존재하는 원소이면 true, 아니면 false를 반환한다")
    @CsvSource({"1,true", "2, true", "3, true", "4, false", "5, false"})
    @ParameterizedTest
    void checkElements(int element, boolean result) {
        assertThat(numbers.contains(element)).isEqualTo(result);
    }
}
