package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.addAll(List.of(1,1,2,3));
    }

    @Test
    @DisplayName("요구사항1 : 1은 중복이므로 총 3개의 요소를 가져야 한다")
    void size_shouldHaveThreeElements() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 : numbers는 1,2,3을 모두 가져야 한다")
    void contains_shouldReturnTrueForExistingValues(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항3 : 1,2,3 을 포함하고 4,5를 포함하지 않아야 한다")
    void contains_shouldReturnExpected(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }


}
