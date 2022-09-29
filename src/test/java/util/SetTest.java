package util;

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
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("numbers 사이즈 테스트")
    public void hasSizeFour_ShouldReturnTrueForSizeFour() {
        assertThat(numbers).hasSize(4);
    }

    @ParameterizedTest(name = "numbers 안에 숫자 {0} 값의 존재유무 테스트")
    @ValueSource(ints = {1, 2, 3})
    public void isOneTwoThree_ShouldReturnTrueForOneTwoThree(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "4,5"})
    @DisplayName("numbers 안에 존재하는 숫자면 성공, 그렇지 않으면 실패하는 테스트")
    public void containsValue_ShouldReturnTrueForContainsValue(int actual, int expected) {
        assertThat(numbers.contains(actual)).isEqualTo(numbers.contains(expected));
    }
}