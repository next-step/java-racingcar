package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

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
    @DisplayName("size()를 이용하여 Set<>의 크기를 알 수 있다")
    void size() {
        // given
        // when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest(name = "size({0})를 이용하여 Set<>에 값이 존재하는지를 확인 (@ValueSource 이용)")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "numbers(Set<>)에서 size({0})을 하면 {1}이다 (@CsvSource 이용)")
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void contains2(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }

}
