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

    // Test Case 구현

    @Test
    @DisplayName("Set의 크기를 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set에 값이 존재하는지를 확인. 실제 Set에 있는 값만 확인 가능")
    @ValueSource(ints = {1, 2, 3})
    void containsOnlyTrue(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set에 값이 존재하는지를 확인. 실제 Set에 있던 없던 확인 가능")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsAllCase(int num, boolean isExist) {
        assertThat(numbers.contains(num)).isEqualTo(isExist);
    }
}