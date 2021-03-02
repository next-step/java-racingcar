package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("Set 클래스에 대한 학습 테스트")
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
    @DisplayName("집합 크기 확인하기")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("집합 원소 포함 확인하기")
    @ParameterizedTest @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("집합에 없는 원소 확인하기")
    @ParameterizedTest @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsFalse(int number, boolean bool) {
        assertThat(numbers.contains(number)).isEqualTo(bool);

    }
}
