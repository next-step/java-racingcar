package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void check_size_of_set_is_equal_to() {
        assertThat(numbers.size())
                .isEqualTo(3)
                .isGreaterThan(2);
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void check_size_of_set_with_is_not_equal_to() {
        assertThat(numbers.size())
                .isNotEqualTo(4)
                .isLessThan(4);
    }

    @ParameterizedTest
    @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.")
    @ValueSource(ints = {1,2,3})
    void contains(int input_number) {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
        assertTrue(numbers.contains(input_number));
    }
}
