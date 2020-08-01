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
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현


    @Test
    @DisplayName("Set의 크기를 확인한다.")
    public void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에 특정 값이 존재하는지를 확인한다.")
    public void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set에 특정 값이 존재하면 true, 존재하지 않으면 false를 반환하도록 한다. ")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    public void contains(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
