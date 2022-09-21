package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void SetUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set contains method 정상 case")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set contains method 정상 / 비정상 case")
    @ParameterizedTest
    @CsvSource({
            "1,true",
            "2,true",
            "3,true",
            "4,false",
            "5,false"})
    void containsWithInvalid(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
