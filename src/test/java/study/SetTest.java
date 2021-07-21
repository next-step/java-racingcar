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

    @DisplayName("Set의 크기를 확인 테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 값 존재 확인 테스트 1")
    @Test
    void contains1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("Set의 값 존재 확인 테스트 2")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("결과 값이 다른 경우에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void compareResult(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }

}
