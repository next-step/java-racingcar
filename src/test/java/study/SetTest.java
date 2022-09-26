package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection에 대한 학습 테스트")
class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        Collections.addAll(numbers, 1, 1, 2, 3);
    }

    @Test
    @DisplayName("Set은 중복된 값을 가지지 않는다.")
    void hasUniqueElements() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "Set에 {0}이 존재한다.")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에 1, 2, 3이 존재한다.")
    void containsInitializedValue(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest(name = "Set에 {0}가 존재한다 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set에 어떤 값이 존재하는지 확인한다.")
    void containsOnlyInitializedValue(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}