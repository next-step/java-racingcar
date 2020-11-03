package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.Set;

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
    void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }
    @Test
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void parameterizedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

}
