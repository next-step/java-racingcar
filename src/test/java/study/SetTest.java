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

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @DisplayName("요구사항 1 - Set의 크기를 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("요구사항2 - contains 테스트, @ValueSource 활용")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains1(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항3 - contains 테스트, @CsvSource를 활용")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","4:false"}, delimiter = ',')
    void contains2(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
