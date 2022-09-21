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
    @DisplayName("numbers의 크기를 테스트하는 케이스")
    public void size() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("numbers 안에 숫자 1,2,3 값의 존재유무 테스트하는 케이스")
    public void isOneTwoThree_ShouldReturnTrueForOneTwoThree(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "4,5"}, delimiter = ',')
    @DisplayName("numbers 안에 존재하는 숫자면 성공, 그렇지 않으면 실패하는 테스트 케이스")
    public void containsValue_ShouldReturnTrueForContainsValue(String input, String expected) {
        int actual = Integer.parseInt(input);
        assertThat(numbers.contains(actual)).isEqualTo(numbers.contains(Integer.parseInt(expected)));
    }
}