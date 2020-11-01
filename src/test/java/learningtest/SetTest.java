package learningtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set Collection 테스트")
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
    @DisplayName("사이즈 확인")
    void checkSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("contains를 통한 값 존재 확인")
    @ValueSource(ints = {1, 2, 3})
    void checkSetContaining(int numContaining) {
        assertThat(numbers.contains(numContaining)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("contains로 포함하지 않는 값까지 확인")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void checkSetContaining_withNumNotInSet(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
